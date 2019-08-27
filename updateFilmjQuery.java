package jQueryJava;

import java.io.IOException;
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
 * Servlet implementation class updateFilmjQuery
 */
@WebServlet("/updateFilmjQuery")
public class updateFilmjQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateFilmjQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		System.out.println("update film = " + film);
		dao.updateFilm(film);
		f = dao.getFilmById(id);
		films.add(f);
		sFilms = data.radioTypes(radio, films);
		System.out.println("update sFilm = " + sFilms);
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sFilms);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
