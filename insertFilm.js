/**
 * 
 */

$(function(){
	$("#insertFilm").click(insertFilmJS);
})

function insertFilmJS(){
	var inputId = $("#filmId").val();
	var inputTitle = $("#filmTitle").val();
	var inputYear = $("#filmYear").val();
	var inputDirector = $("#filmDirector").val();
	var inputStars = $("#filmStars").val();
	var inputReview = $("#filmReview").val();
    $.get("insertFilmjQuery",{ id:inputId , title:inputTitle , year:inputYear , director:inputDirector , stars:inputStars , review:inputReview}, function(responseText) {
        $("#insertedFilm").text(responseText);
    });
}