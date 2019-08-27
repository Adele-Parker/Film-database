package classes;

import java.util.ArrayList;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FilmDAO dao = new FilmDAO();
		Film film = new Film();
		
		ArrayList<Film> films = new ArrayList();
		/*films = dao.getAllFilm();
		for(int i = 0; i<films.size(); i++) {
			System.out.println(films.get(i));
		}
		System.out.println(films.get(0));
		*/
		
		film = dao.getFilmById(10002);
		System.out.println(film.toString());
		
		/*films = dao.getByTitle("wars");
		for(int i = 0; i<films.size(); i++) {
			System.out.println(films.get(i));
		}
		
		System.out.println();
		
		films = dao.getByYear(82);
		for(int i = 0; i<films.size(); i++) {
			System.out.println(films.get(i));
		}
		
		System.out.println();
		
		films = dao.getByYear(1992);
		for(int i = 0; i<films.size(); i++) {
			System.out.println(films.get(i));
		}
		
		films = dao.getByDirector("Don Bluth");
		for(int i = 0; i<films.size(); i++) {
			System.out.println(films.get(i));
		}
		
		System.out.println();
		
		films = dao.getByStars("Mark");
		for(int i = 0; i<films.size(); i++) {
			System.out.println(films.get(i));
		}
		
		System.out.println();

		films = dao.getByReview("animation");
		for(int i = 0; i<films.size(); i++) {
			System.out.println(films.get(i));
		}
		
		System.out.println();
		
		films = dao.getByReview("is");
		for(int i = 0; i<films.size(); i++) {
			System.out.println(films.get(i));
		}
		
		System.out.println();
		
		
		dao.deleteFilm(11311);
		film = dao.getFilmById(11311);
		System.out.println(film.toString());
		
		System.out.println();
		
		Film insertFilm = new Film();
		insertFilm.film(11311,"Silence of the Lambs",1991,"Jonathan Demme","Jodie Foster","A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.");
		//System.out.println(insertFilm.toString());
		dao.insertFilm(insertFilm);
		film = dao.getFilmById(11311);
		System.out.println(film.toString());
		
		System.out.println();
		
		Film updateFilm = new Film();
		updateFilm.film(11311,"Silence of the Lambs",1991,"Jonathan Demme","Jodie Foster, Anthony Hopkins","A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.");
		dao.updateFilm(updateFilm);
		film = dao.getFilmById(11311);
		System.out.println(film.toString());
		*/
	}

}
