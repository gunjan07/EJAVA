/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca3_model;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author vinayakPriya
 */

/**
 *
 * @author vinayakPriya
 */
@Entity
@Table(name = "delivery")
public class delivery implements Serializable {
    
        
        
        @Id  @GeneratedValue(strategy=IDENTITY)
	@Column(name = "pkg_id")
	private int pkgid;
        
        @Column(name = "name")
	private String name;
        
        @Column(name = "address")
	private String address;
        
        @Column(name = "phone")
	private String phone;
        
        @Column(name = "create_date")
	private Date date;
        
        @OneToOne(mappedBy="delivery")
        private Pod pod;
        

    /**
     * @return the pkgid
     */
    public int getPkgid() {
        return pkgid;
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
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the pod
     */
    public Pod getPod() {
        return pod;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }


    
}
