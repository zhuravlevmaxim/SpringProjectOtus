function getAllGenre() {
    var resultGenres = $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "/genre",
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success get all genres!");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        async : false
    });
    return resultGenres.responseJSON;
}