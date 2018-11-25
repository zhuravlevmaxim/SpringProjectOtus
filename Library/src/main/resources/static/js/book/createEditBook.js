function createEditBook(book) {

    removeAllChildById("centre");

    var itemBookDiv = document.createElement("div");
    itemBookDiv.setAttribute("class", "itemBook");

    var itemBookForm = document.createElement("form");

    var bookIdP = document.createElement("p");
    var bookIdLabel = document.createElement("label");
    bookIdLabel.setAttribute("for", "bookIdInput");
    bookIdLabel.innerHTML = "ID книги: ";
    bookIdP.appendChild(bookIdLabel);
    var bookIdInput = document.createElement("input");
    bookIdInput.setAttribute("id", "bookIdInput")
    bookIdInput.setAttribute("class", "editInput");
    bookIdInput.disabled = true;
    bookIdInput.value = book.id;
    bookIdP.appendChild(bookIdInput);
    itemBookForm.appendChild(bookIdP);

    var bookTitleP = document.createElement("p");
    var bookTitleLabel = document.createElement("label");
    bookTitleLabel.setAttribute("for", "bookTitleInput");
    bookTitleLabel.innerHTML = "Название: ";
    bookTitleP.appendChild(bookTitleLabel);
    var bookTitleInput = document.createElement("input");
    bookTitleInput.setAttribute("id", "bookTitleInput")
    bookTitleInput.setAttribute("class", "editInput");
    bookTitleInput.value = book.name;
    bookTitleP.appendChild(bookTitleInput);
    itemBookForm.appendChild(bookTitleP);


    var bookCountPageP = document.createElement("p");
    var bookCountPageLabel = document.createElement("label");
    bookCountPageLabel.setAttribute("for", "bookCountPageInput");
    bookCountPageLabel.innerHTML = "Количество страниц: ";
    bookCountPageP.appendChild(bookCountPageLabel);
    var bookCountPageInput = document.createElement("input");
    bookCountPageInput.setAttribute("id", "bookCountPageInput");
    bookCountPageInput.setAttribute("class", "editInput");
    bookCountPageInput.value = book.pageCount;
    bookCountPageP.appendChild(bookCountPageInput);
    itemBookForm.appendChild(bookCountPageP);


    var bookIsbnP = document.createElement("p");
    var bookIsbnLabel = document.createElement("label");
    bookIsbnLabel.setAttribute("for", "bookTitleInput");
    bookIsbnLabel.innerHTML = "ISBN: ";
    bookIsbnP.appendChild(bookIsbnLabel);
    var bookIsbnInput = document.createElement("input");
    bookIsbnInput.setAttribute("id", "bookIsbnInput");
    bookIsbnInput.setAttribute("class", "editInput");
    bookIsbnInput.value = book.isbn;
    bookIsbnP.appendChild(bookIsbnInput);
    itemBookForm.appendChild(bookIsbnP);


    var bookPublishYearP = document.createElement("p");
    var bookPublishYearLabel = document.createElement("label");
    bookPublishYearLabel.setAttribute("for", "bookTitleInput");
    bookPublishYearLabel.innerHTML = "Год издания: ";
    bookPublishYearP.appendChild(bookPublishYearLabel);
    var bookPublishYearInput = document.createElement("input");
    bookPublishYearInput.setAttribute("id", "bookPublishYearInput");
    bookPublishYearInput.setAttribute("class", "editInput");
    bookPublishYearInput.value = book.publishYear;
    bookPublishYearP.appendChild(bookPublishYearInput);
    itemBookForm.appendChild(bookPublishYearP);


    var authors = getAllAuthors();
    var bookAuthorP = document.createElement("p");
    var bookAuthorLabel = document.createElement("label");
    bookAuthorLabel.setAttribute("for", "authorSelect");
    bookAuthorLabel.innerHTML = "Автор: ";
    bookAuthorP.appendChild(bookAuthorLabel);
    var bookAuthorSelect = document.createElement("select");
    bookAuthorSelect.setAttribute("id", "authorSelect");
    authors.forEach(function(author) {
        var bookAuthorOption = document.createElement("option");
        bookAuthorOption.setAttribute("id", "optionAuthor" + author.id);
        if(author.id === book.authorByAuthorId.id) {
            bookAuthorOption.selected = true;
        }
        bookAuthorOption.value = {
            id: author.id,
            fio : author.fio,
            birthday: author.birthday
        };
        bookAuthorOption.text = author.fio + " : " + author.birthday;
        bookAuthorSelect.appendChild(bookAuthorOption);
    });
    bookAuthorP.appendChild(bookAuthorSelect);
    itemBookForm.appendChild(bookAuthorP);


    var genres = getAllGenre();
    var bookGenreP = document.createElement("p");
    var bookGenreLabel = document.createElement("label");
    bookGenreLabel.setAttribute("for", "genreSelect");
    bookGenreLabel.innerHTML = "Жанр: ";
    bookGenreP.appendChild(bookGenreLabel);
    var bookGenreSelect = document.createElement("select");
    bookGenreSelect.setAttribute("id", "genreSelect");
    genres.forEach(function(genre) {
        var bookGenreOption = document.createElement("option");
        bookGenreOption.setAttribute("id", "optionGenre" + genre.id);
        if(genre.id === book.genreId) {
            bookGenreOption.selected = true;
        }
        bookGenreOption.value = {
            id: genre.id,
            genre : genre.genre
        };
        bookGenreOption.text = genre.name;
        bookGenreSelect.appendChild(bookGenreOption);
    });
    bookGenreP.appendChild(bookGenreSelect);
    itemBookForm.appendChild(bookGenreP);


    var publishers = getAllPublisher();
    var bookPublisherP = document.createElement("p");
    var bookPublisherLabel = document.createElement("label");
    bookPublisherLabel.setAttribute("for", "publisherSelect");
    bookPublisherLabel.innerHTML = "Издательство: ";
    bookPublisherP.appendChild(bookPublisherLabel);
    var bookPublisherSelect = document.createElement("select");
    bookPublisherSelect.setAttribute("id", "publisherSelect");
    publishers.forEach(function(publisher) {
        var bookPublisherOption = document.createElement("option");
        bookPublisherOption.setAttribute("id", "optionPublisher" + publisher.id);
        if(publisher.id === book.publishereId) {
            bookPublisherOption.selected = true;
        }
        bookPublisherOption.value = {
            id: publisher.id,
            publisher : publisher.name
        };
        bookPublisherOption.text = publisher.name;
        bookPublisherSelect.appendChild(bookPublisherOption);
    });
    bookPublisherP.appendChild(bookPublisherSelect);
    itemBookForm.appendChild(bookPublisherP);


    var bookDescrP = document.createElement("p");
    var bookDescrLabel = document.createElement("label");
    bookDescrLabel.setAttribute("for", "bookDescInput");
    bookDescrLabel.innerHTML = "Описание: ";
    itemBookForm.appendChild(bookDescrLabel);
    var bookDescTextArea = document.createElement("textarea");
    bookDescTextArea.setAttribute("id", "bookDescTextArea");
    bookDescTextArea.setAttribute("class", "editTextArea");
    bookDescTextArea.value = book.descr;
    bookDescrP.appendChild(bookDescTextArea);
    itemBookForm.appendChild(bookDescrP);

    var editBookButton = document.createElement("button");
    editBookButton.innerHTML = "Edit";
    editBookButton.onclick = function(){
        editBook(authors, genres, publishers);
    }

    itemBookForm.appendChild(editBookButton);

    itemBookDiv.appendChild(itemBookForm);
    document.getElementById("centre").appendChild(itemBookDiv);
}