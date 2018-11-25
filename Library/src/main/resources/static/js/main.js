function main() {

    var rootDiv = document.getElementById("root");

    var exitDIV = document.createElement("div");
    var exitA = document.createElement("a")
    exitA.href = "/logout";
    exitA.innerHTML = "Exit";
    exitDIV.appendChild(exitA);
    rootDiv.appendChild(exitDIV);

    var searchBookDIV = document.createElement("div");
    searchBookDIV.setAttribute("id", "searchBook");
    searchBookDIV.setAttribute("class", "searchBook");
    rootDiv.appendChild(searchBookDIV);

    var listGenreDiv = document.createElement("div");
    listGenreDiv.setAttribute("id", "listGenre");
    listGenreDiv.setAttribute("class", "listGenre");
    rootDiv.appendChild(listGenreDiv);

    var centreDiv = document.createElement("div");
    centreDiv.setAttribute("id", "centre");
    centreDiv.setAttribute("class", "centre");
    rootDiv.appendChild(centreDiv);

    var footerDiv = document.createElement("div");
    footerDiv.setAttribute("id", "footer");
    footerDiv.setAttribute("class", "footer");
    rootDiv.appendChild(footerDiv);

    createSearchPanel(searchBookDIV);
    createLeftPanel(listGenreDiv);
    createFooterPanel(footerDiv);
}