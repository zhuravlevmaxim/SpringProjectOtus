function removeAllChildById(idDiv) {
    var listBookDiv = document.getElementById(idDiv);
    while (listBookDiv.firstChild) {
        listBookDiv.removeChild(listBookDiv.firstChild);
    }
}