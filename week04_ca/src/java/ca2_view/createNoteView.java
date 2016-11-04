/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_view;

import ca2_business.Categories;
import ca2_business.NotesBean;
import ca2_business.UsersBean;
import ca2_model.Notes;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;


/**
 *
 * @author vinayakPriya
 */
@Named
@RequestScoped
public class createNoteView {
    
    @Resource(lookup = "concurrent/myThreadPool") private ManagedExecutorService service;
      
    @EJB private NotesBean notesBean;
    @EJB private UsersBean userBean;
    @Inject private LoginView login;
    @Inject private Categories categories;
     
	private int notesid;
	private String title;
	private String category;
	private String content;
        private Date note_date;
       
       
    /**
     * @return the notesid
     */
    public int getNotesid() {
        return notesid;
    }

    /**
     * @param notesid the notesid to set
     */
    public void setNotesid(int notesid) {
        this.notesid = notesid;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

 
 

    /**
     * @return the note_date
     */
    public Date getNote_date() {
        return note_date;
    }

    /**
     * @param note_date the note_date to set
     */
    public void setNote_date(Date note_date) {
        this.note_date = note_date;
    }
    
   
     public String createNote(){
        Notes note=new Notes();
        note.setNotesid(notesid);
        note.setNote_date(new Date());
        note.setTitle(title);
        note.setCategory(category);
        note.setContent(content);
        note.setUser(userBean.findById(login.getUsername()));
        notesBean.create(note);
        String message=Json.createObjectBuilder()
                                .add("title",note.getTitle())
                                .add("date",note.getNote_date().toString())
                                .add("by", note.getUser().getUserid())
                                .add("category",note.getCategory())
                                .add("content",note.getContent())
                                .build()
                                .toString();
        service.submit(()->{
        categories.lock(()->{
        categories.broadcast(note.getCategory(), message);
        });
        
        });
        
        service.submit(()->{
        categories.lock(()->{
        categories.broadcast("all", message);
        });
        
        });
        
        return ("Menu");
                       
    }
}
