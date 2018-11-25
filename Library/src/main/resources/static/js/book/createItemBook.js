function createItemBook(book) {

    var itemBookDiv = document.createElement("div");
    itemBookDiv.setAttribute("id", "itemBook" + book.id);
    itemBookDiv.setAttribute("class", "itemBook");

    var bookTitleH2 = document.createElement("h2");
    bookTitleH2.innerHTML = book.name;
    itemBookDiv.appendChild(bookTitleH2);

    var imgDiv = document.createElement("div");
    imgDiv.setAttribute("class", "imgDiv");
    var imgBook = new Image(165, 215);
    imgBook.addEventListener('load', function() {
        console.log("IMG LOAD DONE!");
    });
    imgBook.src = 'data:image/png;base64,'+ book.image;
    imgDiv.appendChild(imgBook);
    itemBookDiv.appendChild(imgDiv);

    var infoBookDiv = document.createElement("div");
    infoBookDiv.setAttribute("class", "infoBookDiv");

    var nameP = document.createElement("p");
    nameP.innerHTML = "Название: " + book.name;
    infoBookDiv.appendChild(nameP);

    var pageCountP = document.createElement("p");
    pageCountP.innerHTML = "Количество страниц: " + book.pageCount;
    infoBookDiv.appendChild(pageCountP);

    var isbnP = document.createElement("p");
    isbnP.innerHTML = "ISBN: " + book.isbn;
    infoBookDiv.appendChild(isbnP);

    var publishYearP = document.createElement("p");
    publishYearP.innerHTML = "Год издания: " + book.publishYear;
    infoBookDiv.appendChild(publishYearP);

    var authorP = document.createElement("p");
    authorP.innerHTML = "Автор: " + book.authorByAuthorId.fio;
    infoBookDiv.appendChild(authorP);

    var genreP = document.createElement("p");
    var genre = getGenreById(book.genreId);
    genreP.innerHTML = "Жанр: " + genre.name;
    infoBookDiv.appendChild(genreP);

    var publisherP = document.createElement("p");
    var publisher = getPublisherById(book.publisherId);
    publisherP.innerHTML = "Издательство: " + publisher.name;
    infoBookDiv.appendChild(publisherP);

    var descrP = document.createElement("p");
    descrP.innerHTML = "Описание: " + book.descr;
    infoBookDiv.appendChild(descrP);

    itemBookDiv.appendChild(infoBookDiv);

    var buttonsDiv = document.createElement("div");
    buttonsDiv.setAttribute("class", "buttonsDiv");
    var downloadBookBtn = document.createElement("button");
    downloadBookBtn.setAttribute("class", "btn");
    downloadBookBtn.innerHTML = "Download book";
    downloadBookBtn.onclick = () => {
        downloadBook(book)
    };
    downloadBookBtn.addEventListener("mouseover", eventListenerFunction);
    buttonsDiv.appendChild(downloadBookBtn);
    itemBookDiv.appendChild(buttonsDiv);

    var editBookBtn = document.createElement("button");
    editBookBtn.innerHTML = "Edit book";
    editBookBtn.setAttribute("class", "btn");
    editBookBtn.onclick = () => {
        editBook(book);
    }
    editBookBtn.addEventListener("mouseover", eventListenerFunction);
    buttonsDiv.appendChild(editBookBtn);
    itemBookDiv.appendChild(buttonsDiv);

    var deleteBookBtn = document.createElement("button");
    deleteBookBtn.innerHTML = "Delete book";
    deleteBookBtn.setAttribute("class", "btn");
    deleteBookBtn.onclick = () => {
        deleteBook(book);
    }
    deleteBookBtn.addEventListener("mouseover", eventListenerFunction);
    buttonsDiv.appendChild(deleteBookBtn);
    itemBookDiv.appendChild(buttonsDiv);

    document.getElementById("centre").appendChild(itemBookDiv);

    function downloadBook(book){
        console.log("CLICK DOWNLOAD BOOK!");
        console.log(book);
    }

    function editBook(book){
        console.log("click edit book!");
        createEditBook(book);
    }

    function deleteBook(book){
        $.ajax({
            type : "DELETE",
            contentType : "application/json",
            url : "/book/" + book.id,
            dataType : "json",
            success : function(result) {
                console.log("success delete book!");
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
}