/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca3_business;

import ca3_model.Pod;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vinayakPriya
 */
@Stateless
public class PodBean {
    @PersistenceContext private EntityManager em;
    
    public Pod create(Pod p) {
        System.out.println("pod "+p.getPodid());
			em.persist(p);
                        System.out.println("created pod");
                        return p;
	}
    
}
