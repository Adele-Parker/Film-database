
$(function(){
	$("#getAllFilms").click(getAllFilmsJS);
	$("#getFilmsById").click(getByIdJS);
	$("#getFilmsByTitle").click(getByTitleJS);
	$("#getFilmsByYear").click(getByYearJS);
	$("#getFilmsByDirector").click(getByDirectorJS);
	$("#getFilmsByStars").click(getByStarsJS);
	$("#getFilmsByReview").click(getByReviewJS);
})

function getAllFilmsJS(){
	var radioValue = null;
	radioValue = $("input[name='format']:checked").val();
$.get("getAllFilmsjQuery",{format:radioValue}, function(responseText) {
    $("#getAll").text(responseText);
});
}

function getByIdJS(){
	var inputBox = $("#filmId").val();
	var radioValue = $("input[name='format']:checked").val();
    $.get("getFilmByIdjQuery",{format:radioValue , id:inputBox}, function(responseText) {
        $("#getById").text(responseText);
    });
}

function getByTitleJS(){
	var inputBox = $("#filmTitle").val();
	var radioValue = $("input[name='format']:checked").val();
    $.get("getFilmByTitlejQuery",{format:radioValue , title:inputBox}, function(responseText) {
        $("#getByTitle").text(responseText);
    });
}

function getByYearJS(){
	var inputBox = $("#filmYear").val();
	var radioValue = $("input[name='format']:checked").val();
    $.get("getFilmByYearjQuery",{format:radioValue , year:inputBox}, function(responseText) {
        $("#getByYear").text(responseText);
    });
}

function getByDirectorJS(){
	var inputBox = $("#filmDirector").val();
	var radioValue = $("input[name='format']:checked").val();
    $.get("getFilmByDirectorjQuery",{format:radioValue , director:inputBox}, function(responseText) {
        $("#getByDirector").text(responseText);
    });
}

function getByStarsJS(){
	var inputBox = $("#filmStars").val();
	var radioValue = $("input[name='format']:checked").val();
    $.get("getFilmByStarsjQuery",{format:radioValue , stars:inputBox}, function(responseText) {
        $("#getByStars").text(responseText);
    });
}

function getByReviewJS(){
	var inputBox = $("#filmReview").val();
	var radioValue = $("input[name='format']:checked").val();
    $.get("getFilmByReviewjQuery",{format:radioValue , review:inputBox}, function(responseText) {
        $("#getByReview").text(responseText);
    });
}
