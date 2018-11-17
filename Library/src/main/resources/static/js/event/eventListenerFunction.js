function eventListenerFunction(event) {
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/event",
        data : JSON.stringify(event),
        dataType : "json",
        success : function(result) {
            console.log("success event!");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}