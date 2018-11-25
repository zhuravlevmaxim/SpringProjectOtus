function getAllAuthors() {
    var resultAuthors = $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "/author",
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success get all author");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        async : false
    });
    return resultAuthors.responseJSON;
}