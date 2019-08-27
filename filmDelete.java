

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Film;
import classes.FilmDAO;

/**
 * Servlet implementation class filmDelete
 */
@WebServlet("/filmDelete")
public class filmDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filmDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String param = request.getParameter("id");
		FilmDAO dao = new FilmDAO();
		Film film = new Film();
		int id = Integer.parseInt(param);
		dao.deleteFilm(id);
		
		//request.setAttribute("film",film);
		String address = "/WEB-INF/DeleteSuccess.html";

		RequestDispatcher dispatcher =
	    	      request.getRequestDispatcher(address);
		request.getRequestDispatcher(address).include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
