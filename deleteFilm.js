/**
 * 
 */
$(function(){
	$("#deleteFilm").click(deleteFilmJS);
})

function deleteFilmJS(){
	var inputId = $("#filmId").val();
    $.get("deleteFilmjQuery",{ id:inputId}, function(responseText) {
        $("#deletedFilm").text(responseText);
    });
}