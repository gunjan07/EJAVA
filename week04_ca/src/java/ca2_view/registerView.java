/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_view;
import ca2_business.GroupsBean;
import ca2_business.UsersBean;
import ca2_model.GroupId;
import ca2_model.Groups;
import ca2_model.Users;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.commons.codec.digest.DigestUtils;


/**
 *
 * @author vinayakPriya
 */
@Named
@RequestScoped
public class registerView {
    
    @EJB private GroupsBean groupsBean;
    @EJB private UsersBean usersBean;
    
    private String username;
    private String password;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
    
    public void registerUser(){
        Users user=new Users();
        user.setUserid(username);
        final String hash = DigestUtils.sha256Hex(password);
        user.setPassword(hash);
        GroupId grpId=new GroupId();
        grpId.setGroupId("student");
        grpId.setUserid(username);
        Groups group=new Groups();
        group.setGroupId(grpId);
        usersBean.create(user);
        groupsBean.create(group);
    }
    
}
