package classes;

public class Film {
	
private int id;
private String title;
private int year;
private String director;
private String stars;
private String review;	

public void film(int id, String title, int year, String director, String stars, String review) {

	this.id = id;
	this.title = title;
	this.year = year;
	this.director = director;
	this.stars = stars;
	this.review = review;
	
}

public void setId(int id) {
	this.id = id;
}

 public int getId() {
	 return id;
 }
 
public void setTitle(String title) {
	this.title = title;
}
 
public String getTitle() {
	return title;
}

public void setYear(int year) {
	this.year = year;
}

public int getYear() {
	return year;
}

public void setDirector(String director) {
	this.director = director;
}

public String getDirector() {
	return director;
}

public void setStars(String stars) {
	this.stars = stars;
}

public String getStars() {
	return stars;
}

public void setReview(String review) {
	this.review = review;
}

public String getReview() {
	return review;
}

public String toString() {
	return "ID: " + id + " Title: " + title + " Year: " + year + " Director: " + director + " Stars: " + stars + " Review: " + review;
}

}