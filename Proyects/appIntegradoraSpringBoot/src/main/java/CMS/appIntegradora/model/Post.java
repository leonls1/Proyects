    package CMS.appIntegradora.model;

    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
    import jakarta.persistence.JoinTable;
    import jakarta.persistence.ManyToMany;
    import jakarta.persistence.ManyToOne;
    import jakarta.persistence.OneToMany;
    import jakarta.persistence.OneToOne;
    import jakarta.persistence.Table;
    import java.util.List;
    import lombok.Getter;
    import lombok.Setter;

    @Getter@Setter
    @Entity
    @Table
    public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String Title;

        private String Slug;

        private String extract;

        @ManyToOne
        private User user;

        @ManyToMany    
        @JoinTable(name = "post_category",
                 joinColumns = @JoinColumn(name = "post_id"),
                 inverseJoinColumns = @JoinColumn(name = "category_id"))
        @JsonIgnoreProperties("posts")
        private List<Category> categories;

        private String image;

        //it can be an enum
        private String type;

        @OneToMany(mappedBy = "post")
        private List<Comment> comments;

        @OneToOne
        @JoinColumn(name = "id_content")
        private Content content;

        @OneToOne(mappedBy = "post")
        private PostMetadata postMetadata;
    }
