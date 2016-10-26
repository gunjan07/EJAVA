/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CA1_rest;
import CA1_EnterpriseBeans.PeopleBean;
import CA1_model.Appointment;
import CA1_model.People;
import java.util.Collection;
import java.util.UUID;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
/**
 *
 * @author vinayakPriya
 */
@RequestScoped
 @Path("/people")
public class PeopleResource {
        @EJB private PeopleBean peopleBean;
        @POST
	@Consumes("application/x-www-form-urlencoded") //?
        public Response post(MultivaluedMap<String, String> formData) {
                People people=new People();
                people.setName(formData.getFirst("name"));
                people.setEmail(formData.getFirst("email"));
                people.setPid(UUID.randomUUID().toString().substring(0, 8));
                peopleBean.create(people);
		return (Response.ok().build());
	}
    
        @GET
	@Produces("application/json")
        public Response verify(@QueryParam("email") String email) {
      
		Collection<Appointment> checkemail=peopleBean.findByEmail(email);
                if (checkemail.isEmpty())
                {
			return (Response
					.status(Response.Status.NOT_FOUND)
					.entity("Not found: email=" + email)
					.build());
                }
                    return (Response.ok().build());
        }
        
        
        
            
    
}
