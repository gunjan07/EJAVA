/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca3_business;

import ca3_model.Pod;
import java.util.Collection;
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
public class PodBean {
    private static final String queryString="Select n from Pod n";
    @PersistenceContext private EntityManager em;
    
    public Pod create(Pod p) {
        System.out.println("pod "+p.getPodid());
			em.persist(p);
                        System.out.println("created pod");
                        return p;
	}
    
    public Collection<Pod> getPods(){
        TypedQuery<Pod> query=em.createQuery(queryString,Pod.class);
        return query.getResultList();
    }

    public void saveintoDB(Pod p) {
        Pod po=em.find(Pod.class,p.getPodid());
        p.setDelivery(po.getDelivery());
        
        System.out.println("entered save");
        em.merge(p);
        
    }

    public Pod findById(String parameter) {
        Pod po=em.find(Pod.class,parameter);
        return po;
    }
    
    public void updateToDb(Pod p){
          em.merge(p);
        
    }
}
