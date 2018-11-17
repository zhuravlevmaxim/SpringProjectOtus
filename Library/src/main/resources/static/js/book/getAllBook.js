function getAllBook() {
    var resultBooks = $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "/book",
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success get all books!");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        async : false
    });
    return resultBooks.responseJSON;
}