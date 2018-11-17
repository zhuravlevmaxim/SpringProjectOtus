function clickItemGenreList(genre) {
    var resultBooks = $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "/book/" +genre.id+ "/genreid",
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success get books!");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        async : false
    });
    return resultBooks.responseJSON;
}