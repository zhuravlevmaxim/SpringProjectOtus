function createLeftPanel(listGenreDiv) {

    var listGenre = getListGenre();
    var listGenreUl = document.createElement("ul");

    var allBookLi = document.createElement("li");
    var allBookA = document.createElement("a");
    allBookA.href = "#" + "Allbook";
    allBookA.innerText = "Все книги";
    allBookA.onclick = function(){
        createListBook(getAllBook());
    }
    allBookA.addEventListener("mouseover", eventListenerFunction);
    allBookLi.appendChild(allBookA);
    listGenreUl.appendChild(allBookLi);

    listGenre.forEach(function (genre) {
        const listGenreLi = document.createElement("li");
        var genreItemA = document.createElement("a");
        genreItemA.href = "#" + genre.name;
        genreItemA.innerText = genre.name;
        genreItemA.onclick = function(){
            createListBook(clickItemGenreList(genre));
        }
        genreItemA.addEventListener("mouseover", eventListenerFunction);
        listGenreLi.appendChild(genreItemA);
        listGenreUl.appendChild(listGenreLi);
    });
    listGenreDiv.appendChild(listGenreUl);
}