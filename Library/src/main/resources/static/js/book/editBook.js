function editBook(authors, genres, publishers) {
    var formData = {
        id : $("#bookIdInput").val(),
        name : $("#bookTitleInput").val(),
        pageCount : $("#bookCountPageInput").val(),
        isbn : $("#bookIsbnInput").val(),
        publishYear : $("#bookPublishYearInput").val(),
        descr : $("#bookDescTextArea").val(),
        authorByAuthorId : authors[document.getElementById("authorSelect").selectedIndex],
        genreId : genres[document.getElementById("genreSelect").selectedIndex].id,
        publisherId : publishers[document.getElementById("publisherSelect").selectedIndex].id
    }

    console.log(formData)

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/book/editbook",
        data : JSON.stringify(formData),
        dataType : "json",
        success : function(result) {
            console.log("success edit book");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}