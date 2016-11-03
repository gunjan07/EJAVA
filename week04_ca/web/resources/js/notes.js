$(function() {

	var writeToNoticeBoard = function(text) {
		$("#chatarea").val(text + "\n" + $("#chatarea").val());
	};
        var url = "ws://localhost:8080/week04_ca/display";
	var socket= new WebSocket(url);

	$("#displayBtn").on("click", function() {
               socket.send($("#category").val());
		
	});

	socket.onmessage = function(evt) {
		// {message: "the message" , timestamp: "time" }
		var msg = JSON.parse(evt.data);
               
                writeToNoticeBoard("Created on : "+msg.date+",  Created By : "+msg.by +"\n");
                writeToNoticeBoard("Content : "+msg.content);
                writeToNoticeBoard("Note Title : "+ msg.title);
                
	};
	socket.onopen = function() {
		
               
	};
	socket.onclose = function() {
		writeToNoticeBoard("Disconnected from  server");
	};

});

