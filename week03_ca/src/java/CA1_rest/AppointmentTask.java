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
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;
/**
 *
 * @author vinayakPriya
 */

public class AppointmentTask implements Runnable {

  
	
        private String email;
	private AsyncResponse asyncResponse;
        @EJB private AppointmentBean appointmentBean;

	public AppointmentTask(AsyncResponse resp,String email) {
		asyncResponse = resp;
                this.email=email;
	}
   @Override
    public void run(){
              
            Collection<Appointment> opt=appointmentBean.getAppointments(this.email);
               
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
         
    }
    
}
