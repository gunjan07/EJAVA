package CA1_model;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinayakPriya
 */
@Entity
@Table(name = "people")
public class People {
    
        @Id 
	@Column(name = "pid")
	private String pid;

        @Column(name = "name")
	private String name;
        
        @Column(name = "email")
        private String email;

        @OneToMany (mappedBy="people")
        private Collection<Appointment> appointments;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the appointments
     */
    public Collection<Appointment> getAppointments() {
        return appointments;
    }

  
    
    
}
