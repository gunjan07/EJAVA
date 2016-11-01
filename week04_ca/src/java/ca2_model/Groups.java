/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
/**
 *
 * @author vinayakPriya
 */
@Entity
@Table(name = "groups")
public class Groups implements Serializable{
    
       
        @EmbeddedId private GroupId groupId;

    /**
     * @return the groupId
     */
    public GroupId getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(GroupId groupId) {
        this.groupId = groupId;
    }
        
    
}
