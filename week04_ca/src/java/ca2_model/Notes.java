/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca2_model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 *
 * @author vinayakPriya
 */
@NamedQuery(name = "Notes.findById", query = "select p.notes from Users p where p.userid = :userid")
@Entity
@Table(name = "notes")
public class Notes {
    
        @Id  @GeneratedValue(strategy=IDENTITY)
	@Column(name = "noteid")
	private int notesid;

         @Column(name="title")
	private String title;
        
        @Column(name="category")
	private String category;
        
        @Column(name="content")
	private String content;
        
        @Column(name="note_date")
        private Date note_date;
        
        @JoinColumn(name="userid",referencedColumnName="userid")
        @ManyToOne private Users user;

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
     * @return the user
     */
    public Users getUser() {
        return user;
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

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }
    
    
}
