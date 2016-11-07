/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca3_view;

import ca3_business.PodBean;
import ca3_business.deliveryBean;
import ca3_model.Pod;
import ca3_model.delivery;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author vinayakPriya
 */
@Named
@RequestScoped
public class deliveryView {
    @EJB private deliveryBean dBean;
    @EJB private PodBean pBean;
    private String name;
    private String address;
    private int phone;
   


    
    public String postDelivery(){
         delivery d=new delivery();
         d.setAddress(address);
         d.setName(name);
         d.setPhone(phone);
         dBean.create(d);
         Pod pod=new Pod();
         pod.setDelivery(d);
         pBean.create(pod);
       return null;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    
}
