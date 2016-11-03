/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_view;

import ca2_business.UsersBean;
import ca2_model.Notes;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author vinayakPriya
 */
@Named
@SessionScoped
public class postedNotesView implements Serializable {
    @EJB private UsersBean userBean;
     @Inject private LoginView login;
    
    private Collection<Notes> notes;
    
    public void getDisplayNotes(){
        this.setNotes(userBean.getNotes(login.getUsername()));
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(Collection<Notes> notes) {
        this.notes = notes;
    }

    /**
     * @return the notes
     */
    public Collection<Notes> getNotes() {
        return notes;
    }
    
     
    
}
