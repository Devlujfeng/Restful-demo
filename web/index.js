var source = null;
$(function() {
    $("#startBtn").on("click", function() {
       source = new EventSource("api/counter?start=" + $("#startNum").val());
       source.onmessage = eventHandler;
    });
});

function eventHandler(event) {
    console.log("event = " + JSON.stringify(event));
    $("#counter").text(event.data);
}

