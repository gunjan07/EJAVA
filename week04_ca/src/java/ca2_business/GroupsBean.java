/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_business;
import ca2_model.Groups;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author vinayakPriya
 */

@Stateless
public class GroupsBean {

    
    @PersistenceContext private EntityManager em;
    
    public Groups create(Groups group) {
			em.persist(group);
                        System.out.println("created group");
                        return (group);
	}
    
}

