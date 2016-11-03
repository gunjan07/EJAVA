/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_view;
import ca2_business.Categories;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;


import javax.websocket.server.ServerEndpoint;



/**
 *
 * @author vinayakPriya
 */

@RequestScoped
@ServerEndpoint("/display")
public class displayView {

	//@Resource(lookup = "concurrent/myThreadPool") private ManagedScheduledExecutorService executor;
        private String category;
        @Inject private Categories categories;
        
	@OnOpen
	public void open(Session session) {
              
		System.out.println(">>> new connection: " + session.getId());
                
                 
	}

	@OnMessage
	public void message(final Session session, final String msg) {
		System.out.println(">>> message: " + msg);
                System.out.println("inside on message"+session.getId());
                this.category=msg;
                categories.lock(()->{categories.addSession(category, session);});
//
//		executor.submit(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(">>> in thread");
//				final JsonObject message = Json.createObjectBuilder()
//						.add("message", msg)
//						.add("timestamp", (new Date()).toString())
//						.build();
//
//				for (Session s: session.getOpenSessions())
//					try {
//						s.getBasicRemote().sendText(message.toString());
//					} catch(IOException ex) {
//						try { s.close(); } catch (IOException e) { }
//					}
//			}
//		});
//		System.out.println(">>> exiting message");
	}
	
        
        @OnClose
        public void Close(Session session){
            //categories.lock(()->{
        
             //categories.remove(category, session);   
           // });
            
        }
}

    

