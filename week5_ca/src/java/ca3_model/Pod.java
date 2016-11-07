/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca3_model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author vinayakPriya
 */
@Entity
@Table(name = "pod")
public class Pod implements Serializable {
    
        @Id  @GeneratedValue(strategy=IDENTITY)
	@Column(name = "pod_id")
	private int podid;
        
        @Column(name = "note")
	private String note;
        @Lob
        @Column(name = "image")
	private byte[] image;
        
        @Column(name = "delivery_date")
	private Date date;
        
        @Column(name = "ack_id")
        private int ackid;
        
        @OneToOne
        @JoinColumn(name="pkg_id",referencedColumnName="pkg_id")
        private delivery delivery;

    /**
     * @return the podid
     */
    public int getPodid() {
        return podid;
    }

    /**
     * @param podid the podid to set
     */
    public void setPodid(int podid) {
        this.podid = podid;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
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
     * @return the ackid
     */
    public int getAckid() {
        return ackid;
    }

    /**
     * @param ackid the ackid to set
     */
    public void setAckid(int ackid) {
        this.ackid = ackid;
    }

    /**
     * @return the delivery
     */
    public delivery getDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(delivery delivery) {
        this.delivery = delivery;
    }

    public void saveintoDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
