package CA1_model;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
public class people {
    
        @Id @GeneratedValue(strategy=IDENTITY)
	@Column(name = "pid")
	private Integer pid;

	private String name;
        
        private String email;
    
    
}
