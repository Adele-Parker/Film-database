

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.w3c.dom.Document;

import classes.Film;
import classes.FilmDAO;
import classes.dataTypes;

/**
 * Servlet implementation class getFilmById
 */
@WebServlet("/getFilmById")
public class getFilmById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getFilmById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pId = request.getParameter("id");
		String radio = request.getParameter("format");
		String sFilm = "";
		int id = Integer.parseInt(pId);
		FilmDAO dao = new FilmDAO();
		dataTypes data = new dataTypes();
		Film film = new Film();
		ArrayList<Film> films = new ArrayList<Film>();
		
		film = dao.getFilmById(id);
		films.add(film);
		sFilm = data.radioTypes(radio, films);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.write(sFilm);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
