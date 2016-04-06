var source;
$(function() {
    
    source = new EventSource("api/chatroom");
    source.onmessage = function(event) {
        console.log("got message");
        var chat = JSON.parse(event.data);
        var $messages = $("#messages");
        console.log(">> msg = " + JSON.stringify(chat));
        $messages.text(chat.name + ": " + chat.message + "\n" 
                + $messages.text());
    }
    
   $("#sendBtn").on("click", function() {
       $.get("api/chatroom/newMessage2", { 
           name: $("#name").val(),
           message: $("#msg").val()
       }).done(function() {
          $("#msg").val(""); 
       });
   }) 
});


//$.get("api/chatroom/newMessage2/" + $("#name").val() +"/" +$("#msg").val()
