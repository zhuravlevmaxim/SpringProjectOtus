function getAllPublisher() {
    var resultPublishers = $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "/publisher",
        data : "",
        dataType : "json",
        success : function(result) {
            console.log("success get all publisher!");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        async : false
    });
    return resultPublishers.responseJSON;
}