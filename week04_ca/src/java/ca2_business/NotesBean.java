/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_business;

import ca2_model.Notes;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author vinayakPriya
 */
@Stateless
public class NotesBean {
    
    
    private static final String queryString="Select n from Notes n where (n.category = :categoryId)";
    private static final String queryStringAll="Select n from Notes n";
    @PersistenceContext private EntityManager em;
    
    public void create(Notes note) {
			em.persist(note);
                         
	}
    
    public String getAllNotes(String category) {
        
        TypedQuery<Notes> query;
        if(category.matches("all")){
            query=em.createQuery(queryStringAll,Notes.class);
                                   
        }
        else{
            query=em.createQuery(queryString,Notes.class);
            query.setParameter("categoryId",category);
        }
        JsonArrayBuilder message=Json.createArrayBuilder();
                 for(Notes n: query.getResultList()) 
                {
                   
                     JsonObjectBuilder note = Json.createObjectBuilder();
                        note.add("title",n.getTitle());
                        note.add("date",n.getNote_date().toString());
                        note.add("by", n.getUser().getUserid());
                        note.add("category",n.getCategory());
                        note.add("content",n.getContent());
                        message.add(note);
                }
                        
                return message.build().toString();
	}
    
}
