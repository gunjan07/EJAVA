/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_business;
import ca2_model.Notes;
import ca2_model.Users;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author vinayakPriya
 */

@Stateless
public class UsersBean {
    
    @PersistenceContext private EntityManager em;
    
    public Users create(Users user) {
			em.persist(user);
                        System.out.println("created user");
                        return (user);
	}
    
    public Users findById(String userId){
           Users user=em.find(Users.class,userId);
           return user;
    }
    
    public Collection<Notes> getNotes(String userId){
        
       return em.createNamedQuery("Notes.findById", Notes.class).setParameter("userid", userId).getResultList();       
 
    }
    
}
