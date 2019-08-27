package classes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(namespace="Film.java")
@XmlRootElement(name="Film")
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmList {
	
	@XmlElementWrapper(name = "filmList")
	@XmlElement(name = "film")
	private ArrayList<Film> films = new ArrayList<Film>();
	
	public void setFilmList(ArrayList<Film> films) {
		this.films = films;
	}
	
	public ArrayList<Film> getFilmList(){
		return films;
	}
	
	

}
