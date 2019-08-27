

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Film;
import classes.FilmDAO;

/**
 * Servlet implementation class insertFilm
 */
@WebServlet("/insertFilm")
public class insertFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String sId = request.getParameter("id");
		String title = request.getParameter("title");
		String sYear = request.getParameter("year");
		String director = request.getParameter("director");
		String stars = request.getParameter("stars");
		String review = request.getParameter("review");
		int id = Integer.parseInt(sId);
		int year = Integer.parseInt(sYear);
		
		FilmDAO dao = new FilmDAO();
		ArrayList<Film> films = new ArrayList<Film>();
		Film film = new Film();
		
		film.film(id, title, year, director, stars, review);
		dao.insertFilm(film);
		
		Film f = new Film();
		f = dao.getFilmById(id);
//		request.setAttribute("film",f);
//		String address = "/WEB-INF/ShowResults.jsp";
//
//		RequestDispatcher dispatcher =
//	    	      request.getRequestDispatcher(address);
//		request.getRequestDispatcher(address).include(request, response);
		
		String result = " # " + f.getId() + " | " + f.getTitle() + " | " + f.getYear() + " | " + f.getDirector() + " | " + f.getStars() + " | " + f.getReview();
		PrintWriter printWriter = response.getWriter();
		printWriter.write(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
