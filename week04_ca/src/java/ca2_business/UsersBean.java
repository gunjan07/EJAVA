/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_business;
import ca2_model.Users;
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
    
}
