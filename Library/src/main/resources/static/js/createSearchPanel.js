function createSearchPanel(searchBookDIV) {


    var searchBookForm = document.createElement("form");
    var searchBookInput = document.createElement("input");
    searchBookInput.setAttribute("id", "searchName");
    searchBookInput.setAttribute("name", "name");
    searchBookForm.appendChild(searchBookInput);
    var searchBookButton = document.createElement("button");
    searchBookButton.onclick = function () {
        searchBook();
    }
    searchBookButton.addEventListener("mouseover", eventListenerFunction);
    searchBookButton.setAttribute("class", "btn");
    searchBookButton.innerText = "Search book!";
    searchBookButton.setAttribute("type", "submit");
    searchBookButton.addEventListener("mouseover", eventListenerFunction);
    searchBookForm.appendChild(searchBookButton);
    searchBookDIV.appendChild(searchBookForm);
}