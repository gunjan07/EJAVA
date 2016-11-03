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
        System.out.println("inside add session");
        System.out.println("category"+category);
        List<Session> allsessions=categories.computeIfAbsent(category,s->new LinkedList<>());
        allsessions.add(session);
        System.out.println("print categories");
        System.out.println(categories.toString());
    }
    
    public void broadcast(String category,String note){
        System.out.println("inside broadcast"+category);
        System.out.println("NOte is"+note);
        System.out.println(categories.get(category));
        categories.get(category).stream().forEach(s->{
            try{
                System.out.println("inside try method");
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
