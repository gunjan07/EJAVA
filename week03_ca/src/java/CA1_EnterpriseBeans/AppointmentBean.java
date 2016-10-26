/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CA1_EnterpriseBeans;

import CA1_model.Appointment;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vinayakPriya
 */
@Stateless
public class AppointmentBean {
    @PersistenceContext private EntityManager em;
    

    public Collection<Appointment> getAppointments(String email) {
         return em.createNamedQuery("Appointment.findByEmail", Appointment.class).setParameter("email", email).getResultList();

//To change body of generated methods, choose Tools | Templates.
    }
}

