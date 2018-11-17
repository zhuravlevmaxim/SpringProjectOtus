function searchBook() {
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/book",
        data : $("#searchName").val(),
        dataType : "json",
        success : function(result) {
            console.log("success search book by name!");
            createListBook(result.responseJSON);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}