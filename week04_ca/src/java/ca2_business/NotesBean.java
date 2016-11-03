/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_business;

import ca2_model.Notes;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author vinayakPriya
 */
@Stateless
public class NotesBean {
    
     @PersistenceContext private EntityManager em;
    
    public Notes create(Notes note) {
			em.persist(note);
                        System.out.println("created note");
                        
                        return (note);
	}
    
}
