/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca3_rest;

import ca3_business.PodBean;
import ca3_model.Pod;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author vinayakPriya
 */
@RequestScoped
@Path("/item")
public class DeliveryDetails {
   
    @EJB private PodBean pBean;
    
        @GET
	@Produces("application/json")
        public Response getItems()   { 
        Collection<Pod> opt=pBean.getPods();
               
                JsonArrayBuilder appointment=Json.createArrayBuilder();
                 for(Pod c: opt) 
                {
                   
                     JsonObjectBuilder deliverydetails = Json.createObjectBuilder();
                        deliverydetails.add("teamId","a2f7a747");
                        deliverydetails.add("podId", c.getPodid());
                        deliverydetails.add("name",c.getDelivery().getName());
                        deliverydetails.add("address",c.getDelivery().getAddress());
                        deliverydetails.add("phone",c.getDelivery().getPhone());
                        appointment.add(deliverydetails);
                }
        return (Response.status(Response.Status.CREATED).entity(appointment.build()).build());
   
}
}
