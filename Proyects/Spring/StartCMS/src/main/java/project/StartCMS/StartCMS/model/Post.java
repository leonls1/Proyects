package project.StartCMS.StartCMS.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Title;

    private String Slug;

    private String extract;

    private User user;

    private Category category;

    private String image;

    //it can be an enum
    private String type;
    
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
    
    @OneToOne
    @JoinColumn(name = "id_content")
    private Content content;
}
