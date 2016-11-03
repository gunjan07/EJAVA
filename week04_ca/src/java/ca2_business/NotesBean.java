/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_business;

import ca2_model.Notes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vinayakPriya
 */
@Stateless
public class NotesBean {
    
    private static final String queryString="Select * from Notes n where (n.category = :categoryId)";
    @PersistenceContext private EntityManager em;
    
    public int create(Notes note) {
			em.persist(note);
                        System.out.println("created note");
                        
                        return 1;
	}
    
    public String getAllNotes(String category) {
//        TypedQuery<Notes> query=em.createQuery(queryString,Notes.class);
//                                query.setParameter("categoryId",category);
//                              
//                        for(note in )
//                                
//                              String message=Json.createObjectBuilder()
//                                .add("title",note.getTitle())
//                                .add("date",note.getNote_date().toString())
//                                .add("by", note.getUser().getUserid())
//                                .add("category",note.getCategory())
//                                .add("content",note.getContent())
//                                .build()
//                                .toString();
//         
                return "";
	}
    
}
