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
                if(msg.length>0)
                {msg.forEach(function (d){
                    print(d);
                    });
                }
                else{
                    print(msg);
                }
               
	};
        
        var print=function(d){
            
                writeToNoticeBoard("Created on : "+d.date+",  Created By : "+d.by +"\n");
                writeToNoticeBoard("Content : "+d.content);
                writeToNoticeBoard("Note Title : "+ d.title+",  Category: "+d.category);
                
        }
        
	socket.onopen = function() {
		
               
	};
	socket.onclose = function() {
		writeToNoticeBoard("Disconnected from  server");
	};

});

