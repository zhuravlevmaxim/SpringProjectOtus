function createListBook(listBook) {

    var listBookDiv = document.getElementById("centre");
    while (listBookDiv.firstChild) {
        listBookDiv.removeChild(listBookDiv.firstChild);
    }
    if(Array.isArray(listBook)) {
        listBook.forEach(function (book) {
            createItemBook(book);
        });
    }
}