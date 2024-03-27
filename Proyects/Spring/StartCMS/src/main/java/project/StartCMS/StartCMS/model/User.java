package project.StartCMS.StartCMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String surname;
    
    private String password;
    
    private String email;
    
    @ManyToMany(mappedBy = "users")
    private List<Group> group;
    
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    
    @OneToOne(mappedBy = "user")
    private UserMetadata userMetadata;
    
}
