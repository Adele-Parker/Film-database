package classes;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;

public class dataTypes {
	
	//private String radio;
	
	public String radioTypes(String radio, ArrayList<Film> films) {
		
		String sFilms = "";
		
		if(radio == null) {
			
			sFilms = toJSON(films);
				
			}else if(radio.equals("xml")) {
				try {
					sFilms = xmlMarshaling(films);
				} catch (JAXBException e) {
					e.printStackTrace();
				}
					
			}else if(radio.equals("json")) {
				
				sFilms = toJSON(films);
				
			}else if(radio.equals("text")) {
				
				for(Film f : films) {
					sFilms += " # " + f.getId() + " | " + f.getTitle() + " | " + f.getYear() + " | " + f.getDirector() + " | " + f.getStars() + " | " + f.getReview();
				}
				
			}
		return sFilms;
		
	}
	
public String xmlMarshaling(ArrayList<Film> films) throws JAXBException {
		
		String marshalled = "";
		FilmList fl = new FilmList();
		fl.setFilmList(films);
		JAXBContext context = JAXBContext.newInstance(FilmList.class);
		Marshaller marshaller = context.createMarshaller();	
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		marshaller.marshal(fl, sw);
		marshalled = marshalled + sw;
		
		return marshalled;
	}		
	
public String toJSON(ArrayList<Film> films) {
		
		String json = new Gson().toJson(films);
		return json;
		
	}

}
