package project.StartCMS.StartCMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class UserMetadata {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //one to one
    private User user;
    
    private String key;
    
    private String value;
    
    private String type;
    
}
