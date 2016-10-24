/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CA1_EnterpriseBeans;

import CA1_model.Appointment;
import CA1_model.People;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author vinayakPriya
 */
@Stateless
public class AppointmentBean {
    @PersistenceContext private EntityManager em;
    
    
    public Optional<Appointment> get(Integer cid) {
		return (Optional.ofNullable(
				em.find(Appointment.class, cid)
		));
	}
    
    public List<Appointment> findByEmail(String email) {
		
		TypedQuery<Appointment> query = em.createNamedQuery(
				"Team.findByName", Appointment.class);
		query.setParameter("email", "%" + email + "%");

		List<Appointment> appointments = query.getResultList();
		return (appointments);
	}
}

