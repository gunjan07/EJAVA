/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_view;
import ca2_business.Categories;
import ca2_business.NotesBean;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;



import javax.websocket.server.ServerEndpoint;



/**
 *
 * @author vinayakPriya
 */

@RequestScoped
@ServerEndpoint("/display")
public class displayView {

	@Resource(lookup = "concurrent/myThreadPool") private ManagedExecutorService service;
        private String category;
        @Inject private Categories categories;
        @EJB private NotesBean notesBean;
        
	@OnOpen
	public void open(Session session) {
       	System.out.println(">>> new connection: " + session.getId());
                 
	}

	@OnMessage
	public void message(final Session session, final String msg) {
		System.out.println(">>> message: " + msg);
                this.category=msg;
                categories.lock(()->{categories.addSession(category, session);});
                String allNotes=notesBean.getAllNotes(category);
            try {
                session.getBasicRemote().sendText(allNotes);

            } catch (IOException ex) {
                    try {
                        session.close();
                    } catch (IOException ex1) {
                        Logger.getLogger(displayView.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                Logger.getLogger(displayView.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
        
        @OnClose
        public void Close(Session session){
            categories.lock(()->{
        
             categories.remove(category, session);   
            });
            
        }
}

    

