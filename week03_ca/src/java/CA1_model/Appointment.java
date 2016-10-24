/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CA1_model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author vinayakPriya
 */
@NamedQuery(name = "Appointment.findByEmail", query = "select p.appointments from People p where p.email = :email")
@Entity
@Table(name = "appointment")
public class Appointment {
    
        @Id 
	@Column(name = "appt_id")
	private int appid;

        @Column(name="description")
	private String description;
        
        @Column(name="appt_date")
        private Date date;
        
        @JoinColumn(name="pid",referencedColumnName="pid")
        @ManyToOne private People people;

    /**
     * @return the appid
     */
    public int getAppid() {
        return appid;
    }

    /**
     * @param appid the appid to set
     */
    public void setAppid(int appid) {
        this.appid = appid;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the people
     */
    public People getPeople() {
        return people;
    }
    
    
    
}
