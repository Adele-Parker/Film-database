package classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.google.gson.*;
import com.google.gson.Gson;
import com.zaxxer.hikari.HikariConfig;


public class FilmDAO {
	
	private String password = "frInspla7";
	private String user = "parkera";
	private String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/" + user;
	//private String cloudUrl = "35.187.65.55";
	//private String cloudUrl = "jdbc:mysql://sixth-syntax-235611:europe-west1:cloud-sql-enterprise-assignment";

	Connection cloudConn;
	Connection conn;
	Statement stat;
	private Film film = new Film();
	
	public ArrayList<Film> getAllFilm() {
		ArrayList<Film> films = new ArrayList<Film>();
		createConnection();
		try {
			String selectAll = "SELECT * FROM films";
			ResultSet result = stat.executeQuery(selectAll);
			System.out.println(result);
			while(result.next()) {
				film = getFilm(result);
				films.add(film);
			}
			stat.close();
			closeConnection();
		}catch(SQLException e) {System.out.println(e);}
		return films;		
	}
	
	public Film getFilmById(int id) {
		createConnection();
		try {
			String selectById = "SELECT * FROM films WHERE id = " + id;
			ResultSet result = stat.executeQuery(selectById);
			while(result.next()) {
				film = getFilm(result);
			}			
			stat.close();
			closeConnection();
			
		}catch(SQLException e) {e.printStackTrace();}
		return film;
	}
	
	public ArrayList<Film> getByTitle(String title){
		ArrayList<Film> films = new ArrayList();
		createConnection();
		try {
			String selectByTitle = "SELECT * FROM films WHERE title LIKE \"%" + title + "%\";";
			//System.out.println(selectByTitle);
			ResultSet result = stat.executeQuery(selectByTitle);
			while(result.next()) {
				film = getFilm(result);
				films.add(film);
			}			
			stat.close();
			closeConnection();
		}catch(SQLException e) {e.printStackTrace();}
		return films;
	}
	
	public ArrayList<Film> getByYear(int year){
		ArrayList<Film> films = new ArrayList();
		createConnection();
		try {
			String selectByYear = "SELECT * FROM films WHERE year LIKE \"%" + year + "%\";";
			//System.out.println(selectByTitle);
			ResultSet result = stat.executeQuery(selectByYear);
			while(result.next()) {
				film = getFilm(result);
				films.add(film);
			}			
			stat.close();
			closeConnection();
		}catch(SQLException e) {e.printStackTrace();}
		return films;
	}
	
	public ArrayList<Film> getByDirector(String director){
		ArrayList<Film> films = new ArrayList();
		createConnection();
		try {
			String selectByDirector = "SELECT * FROM films WHERE director LIKE \"%" + director + "%\";";
			//System.out.println(selectByTitle);
			ResultSet result = stat.executeQuery(selectByDirector);
			while(result.next()) {
				film = getFilm(result);
				films.add(film);
			}			
			stat.close();
			closeConnection();
		}catch(SQLException e) {e.printStackTrace();}
		return films;
	}
	
	public ArrayList<Film> getByStars(String stars){
		ArrayList<Film> films = new ArrayList();
		createConnection();
		try {
			String selectByStars = "SELECT * FROM films WHERE Stars LIKE \"%" + stars + "%\";";
			//System.out.println(selectByTitle);
			ResultSet result = stat.executeQuery(selectByStars);
			while(result.next()) {
				film = getFilm(result);
				films.add(film);
			}			
			stat.close();
			closeConnection();
		}catch(SQLException e) {e.printStackTrace();}
		return films;
	}
	
	public ArrayList<Film> getByReview(String review){
		ArrayList<Film> films = new ArrayList();
		createConnection();
		try {
			String selectByReview = "SELECT * FROM films WHERE Stars LIKE \"%" + review + "%\" LIMIT 50;";
			//System.out.println(selectByTitle);
			ResultSet result = stat.executeQuery(selectByReview);
			while(result.next()) {
				film = getFilm(result);
				films.add(film);
			}			
			stat.close();
			closeConnection();
		}catch(SQLException e) {e.printStackTrace();}
		return films;
	}
	
	public void insertFilm(Film film) {
		createConnection();
		int id = film.getId();
		String title = film.getTitle();
		int year = film.getYear();
		String director =  film.getDirector();
		String stars = film.getStars();
		String review = film.getReview();
		
		try {
			String insertFilm = "INSERT INTO films(id,title,year,director,stars,review) VALUES (" + id + ",'" + title + "'," + year + ",'" + director + "','" + stars + "','" + review+ "');";
			stat.executeUpdate(insertFilm);
		}catch(SQLException e) {e.printStackTrace();}
	}
	
	public void updateFilm(Film film) {
		createConnection();
		int id = film.getId();
		String title = film.getTitle();
		int year = film.getYear();
		String director =  film.getDirector();
		String stars = film.getStars();
		String review = film.getReview();
		
		try {
			String updateFilm = "UPDATE films SET title ='" + title + "', year =" + year + ", director ='" + director + "',stars ='" + stars + "',review = '" + review + "' WHERE id = " + id + ";";
			stat.executeUpdate(updateFilm);
		}catch(SQLException e) {e.printStackTrace();}
		
	}
	
	public void deleteFilm(int id) {
		createConnection();
		try {
			String deleteFilm = "DELETE FROM films WHERE id=" + id +";";
			stat.executeUpdate(deleteFilm);
		}catch(SQLException e) {e.printStackTrace();}
		
	}
	
	private Film getFilm(ResultSet result) {
		Film film = new Film();
		try {
			film.setId(result.getInt("id"));
			film.setTitle(result.getString("title"));
			film.setYear(result.getInt("year"));
			film.setDirector(result.getString("director"));
			film.setStars(result.getString("stars"));
			film.setReview(result.getString("review"));
			
		}catch(SQLException e) {System.out.println(e);}
		return film;
	}
	
	private void createConnection() {
		
//		String instanceConnectionName = "sixth-syntax-235611:europe-west1:cloud-sql-enterprise-assignment";
//		String databaseName = "filmsdb";
//		String IP_of_instance = "35.187.65.55";
//		String username = "root";
//		String password = "parker";
//
//		String jdbcUrl = String.format(
//		    "jdbc:mysql://google/%s?cloudSqlInstance=%s"
//		        + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=%s&password=%s",
//		    databaseName,
//		    instanceConnectionName, username, password);
//
//		Connection connection = null;
//		try {
//			connection = DriverManager.getConnection(jdbcUrl);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			stat = connection.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
			//Class.forName("com.mysql.jdbc.GoogleDriver");
		} catch(Exception e) { System.out.println(e); }
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			//System.out.println("cloudUrl = " + cloudUrl);
			//cloudConn = DriverManager.getConnection(cloudUrl);
			//cloudConn.setAutoCommit(true);
			stat = conn.createStatement();
			//stat = cloudConn.createStatement();
		}catch(SQLException e) {System.out.println(e);}
	}
	
	private void closeConnection() {
		try {
			conn.close();
		}catch(SQLException e) {System.out.println(e);}
	}
	
	private void cloudSqlConnectionOpen() {
		
		//String cloudUrl = System.getProperty("");
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(String.format("jdbc:mysql:///%s", System.getenv("filmsdb")));
		config.setUsername(System.getenv("root"));
		config.setPassword(System.getenv("parker"));
		config.addDataSourceProperty("socketFactory", "com.google.cloud.dql.mysql.SocketFactory");
		config.addDataSourceProperty("cloudSqlInstance", System.getenv("sixth-syntax-235611:europe-west1:cloud-sql-enterprise-assignment"));
		config.addDataSourceProperty("useSSL", "false");
		config.setMaximumPoolSize(5);
		config.setMinimumIdle(5);
		
		String instanceConnectionName = "sixth-syntax-235611:europe-west1:cloud-sql-enterprise-assignment";
		String databaseName = "filmsdb";


		String IP_of_instance = "35.187.65.55";
		String username = "root";
		String password = "parker";

		String jdbcUrl = String.format(
		    "jdbc:mysql://%s/%s?cloudSqlInstance=%s"
		        + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
		IP_of_instance,
		    databaseName,
		    instanceConnectionName);

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcUrl, username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Statement statement = connection.createStatement()) {
		  ResultSet resultSet = statement.executeQuery("SHOW TABLES");
		  while (resultSet.next()) {
		    System.out.println(resultSet.getString(1));
		  }
		}catch(Exception e){
		  e.printStackTrace();
		}
		
	}

}
