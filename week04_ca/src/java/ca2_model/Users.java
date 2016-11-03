/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_model;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vinayakPriya
 */
@Entity
@Table(name = "users")
public class Users {
    
        @Id 
	@Column(name = "userid")
	private String userid;
        
        @Column(name = "password")
	private String password;


        @OneToMany (mappedBy="user")
        private Collection<Notes> notes;
    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }


    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the notes
     */
    public Collection<Notes> getNotes() {
        return notes;
    }
    
    
    
}
