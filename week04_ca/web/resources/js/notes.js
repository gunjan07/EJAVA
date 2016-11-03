$(function() {

	var writeToNoticeBoard = function(text) {
		$("#chatarea").val(text + "\n" + $("#chatarea").val());
	};
        var url = "ws://localhost:8080/week04_ca/display";
	var socket= new WebSocket(url);

	$("#displayBtn").on("click", function() {
            console.log("button clicked");
            console.log("selected");
            console.log($("#category").val());
            socket.send($("#category").val());
		
	});

	socket.onmessage = function(evt) {
		// {message: "the message" , timestamp: "time" }
		var msg = JSON.parse(evt.data);
                console.log(msg);
		writeToNoticeBoard(msg.date + ": " + msg.by +": "+msg.title+":"+msg.content+": "+msg.category);
	};
	socket.onopen = function() {
		writeToNoticeBoard("Connected to  server");
               
	};
	socket.onclose = function() {
		writeToNoticeBoard("Disconnected from  server");
	};

});

