/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CA1_rest;

import CA1_EnterpriseBeans.AppointmentBean;
import CA1_model.Appointment;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutorService;
/**
 *
 * @author Gunjan
 */
@RequestScoped
@Path("/appointment/{email}")
public class AppointmentResource {
    
     private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
	 
        @EJB private AppointmentBean appointmentBean;
        @GET
	@Produces("application/json")
        public void getAppointment(
            @Suspended final AsyncResponse asyncResponse, 
            @PathParam(value = "email") final String email){
        
        executorService.submit(() -> {
            asyncResponse.resume(doGetAppointment(email));
        });
    }

    private Response doGetAppointment(@PathParam("email") String email) {
        Collection<Appointment> opt=appointmentBean.getAppointments(email);
               
                JsonArrayBuilder appointment=Json.createArrayBuilder();
                 for(Appointment c: opt) 
                {
                   
                     JsonObjectBuilder appointmentdetails = Json.createObjectBuilder();
                        appointmentdetails.add("appointmentID",c.getAppid());
                        appointmentdetails.add("dateTime", c.getDate().toString());
                        appointmentdetails.add("description",c.getDescription());
                        appointmentdetails.add("personId",c.getAppid());
                        appointment.add(appointmentdetails);
                }
        return (Response.status(Response.Status.CREATED).entity(appointment.build()).build());
    }   
}