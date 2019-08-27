package jQueryJava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Film;
import classes.FilmDAO;
import classes.dataTypes;

/**
 * Servlet implementation class insertFilmjQuery
 */
@WebServlet("/insertFilmjQuery")
public class insertFilmjQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertFilmjQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//format:radioValue , id:inputId , title:inputTitle , year:inputYear , director:inputDirector , stars:inputStars , review:inputReview
		
		FilmDAO dao = new FilmDAO();
		dataTypes data = new dataTypes();
		ArrayList<Film> films = new ArrayList<Film>();
		Film film = new Film();
		Film f = new Film();
		String sFilms = "";
		String radio = null;
		String sId = request.getParameter("id");
		String title = request.getParameter("title");
		String sYear = request.getParameter("year");
		String director = request.getParameter("director");
		String stars = request.getParameter("stars");
		String review = request.getParameter("review");
		int id = Integer.parseInt(sId);
		int year = Integer.parseInt(sYear);
		
		film.film(id, title, year, director, stars, review);
		System.out.println("film = " + film);
		dao.insertFilm(film);
		f = dao.getFilmById(id);
		films.add(f);
		sFilms = data.radioTypes(radio, films);
		System.out.println("sFilm = " + sFilms);
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sFilms);
		
	}

}
