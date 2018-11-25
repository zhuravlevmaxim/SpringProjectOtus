function getGenreById(idGenre) {
    var resultGenre = $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "/genre/" + idGenre ,
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success get genre by id: " + idGenre);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        async : false
    });
    return resultGenre.responseJSON;
}