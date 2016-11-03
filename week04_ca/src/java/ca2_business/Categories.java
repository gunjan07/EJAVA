/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_business;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.websocket.Session;

/**
 *
 * @author vinayakPriya
 */
@ApplicationScoped
public class Categories {

    private final Lock lock=new ReentrantLock(); 
    private Map<String,List<Session>> categories=new HashMap<>();
    
    public void addSession(String category,Session session){
        List<Session> allsessions=categories.computeIfAbsent(category,s->new LinkedList<>());
        allsessions.add(session);
    }
    
    public void broadcast(String category,String note){
        categories.get(category).stream().forEach(s->{
            try{
                s.getBasicRemote().sendText(note);
            }catch(IOException ex){
                categories.get(category).remove(categories.get(category).indexOf(s));
            }
        
    });
}
 public void remove(String category,Session session){
     categories.get(category).remove(categories.get(category).indexOf(session));
            
    }
 
 public void lock(Runnable block){
     lock.lock();
     try{
         block.run();
     }
     finally{
         lock.unlock();
     }
}
}
