/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CA1_EnterpriseBeans;

import CA1_model.Appointment;
import CA1_model.People;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 *
 * @author vinayakPriya
 */
@Stateless
public class PeopleBean {
    
    @PersistenceContext private EntityManager em;
    
    public People create(People person) {
               em.persist(person);
               return (person);
    }
    
    //private static final String queryString="select po from people p join p.appointment po where (p.email:email)";
    public Collection<Appointment> findByEmail(String email){
    System.out.println("email ayaaaaaa"+email);
        
        return em.createNamedQuery("Appointment.findByEmail", Appointment.class).setParameter("email", email).getResultList();

        
        
        
    }
}
