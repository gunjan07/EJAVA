/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CA1_rest;

import CA1_EnterpriseBeans.AppointmentBean;
import CA1_EnterpriseBeans.PeopleBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import CA1_EnterpriseBeans.PeopleBean;
import CA1_model.Appointment;
import CA1_model.People;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
/**
 *
 * @author vinayakPriya
 */
@RequestScoped
@Path("/appointment/{email}")
public class AppointmentResource {
    @Resource(lookup = "concurrent/myThreadPool")
	private ManagedScheduledExecutorService service;   
        @EJB private AppointmentBean appointmentBean;
        @GET
	@Produces("application/json")
        public void get(@PathParam("email") String email,@Suspended AsyncResponse asyncResponse){
        service.submit(()->{
            Collection<Appointment> opt=appointmentBean.getAppointments(email);
               
                JsonArrayBuilder obj=Json.createArrayBuilder();
                 for(Appointment c: opt) 
                {
                   
                     JsonObjectBuilder objBuilder = Json.createObjectBuilder();
                
                        objBuilder.add("appointmentID",c.getAppid());
                        objBuilder.add("dateTime", c.getDate().toString());
                        objBuilder.add("description",c.getDescription());
                        objBuilder.add("personId",c.getAppid());
                        obj.add(objBuilder);
                }
                 asyncResponse.resume(Response.ok(obj.build()).build());
         
    
});

}
}

