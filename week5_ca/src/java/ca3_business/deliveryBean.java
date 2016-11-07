/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca3_business;

import ca3_model.delivery;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vinayakPriya
 */
@Stateless
public class deliveryBean {
    
    @PersistenceContext private EntityManager em;
    
    public delivery create(delivery d) {
        System.out.println("delivery "+d.getAddress());
			em.persist(d);
                        System.out.println("created delivery");
                        return d;
	}
    
}
