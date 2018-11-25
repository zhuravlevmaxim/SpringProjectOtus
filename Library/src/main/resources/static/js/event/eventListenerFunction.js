function eventListenerFunction(event) {

    var eventData = {
        clientX : event.clientX,
        clientY : event.clientY,
        pageX : event.pageX,
        pageY : event.pageY,
        type : event.type,
        innerHTML : event.relatedTarget.innerHTML
    }

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/event",
        data : JSON.stringify(eventData),
        dataType : "json",
        success : function(result) {
            console.log("success event!");
        },
        error : function(e) {
            console.log("ERROR: ", e);
        }
    });
}