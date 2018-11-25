function createListBook(listBook) {

    removeAllChildById("centre");
    if(Array.isArray(listBook)) {
        listBook.forEach(function (book) {
            createItemBook(book);
        });
    }
}