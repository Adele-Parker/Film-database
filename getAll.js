$(document).on("click", "#getAllFilms", function() {
	var radioValue = null;
		radioValue = $("input[name='format']:checked").val();
    $.get("getAllFilmsjQuery",{format:radioValue}, function(responseText) {
        $("#getAll").text(responseText);
    });
    
});