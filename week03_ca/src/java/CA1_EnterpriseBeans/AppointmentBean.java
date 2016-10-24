/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CA1_EnterpriseBeans;

import CA1_model.Appointment;
import CA1_model.People;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;

/**
 *
 * @author vinayakPriya
 */
@Stateless
public class AppointmentBean {
    @PersistenceContext private EntityManager em;
    

    public Collection<Appointment> getAppointments(String email) {
        System.out.println("insde get appointments");
         return em.createNamedQuery("Appointment.findByEmail", Appointment.class).setParameter("email", email).getResultList();

//To change body of generated methods, choose Tools | Templates.
    }
}

