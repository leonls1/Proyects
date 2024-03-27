package project.StartCMS.StartCMS.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;


public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String surname;
    private String password;
    private String email;
    //many to many
    private Group group;
    
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    
}
