function getPublisherById(idPublisher) {
    var resultPublisher = $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "/publisher/" + idPublisher ,
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success get publisher by id: " + idPublisher);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        async : false
    });
    return resultPublisher.responseJSON;
}