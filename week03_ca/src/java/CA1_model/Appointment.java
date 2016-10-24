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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author vinayakPriya
 */
@NamedQueries({
	@NamedQuery(name = "appointment.findByEmail", 
			query = "select a from appointment a where a.email like :email")
})
@Entity
@Table(name = "appointment")
public class Appointment {
    
        @Id 
	@Column(name = "appt_id")
	private int appid;

	private String description;
        
        private Timestamp date;
        
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
    public Timestamp getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    
    
}
