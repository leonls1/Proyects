package CMS.appIntegradora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter@Setter
@JsonIgnoreProperties({"posts", "categoryUpper"})
public class Category {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    
    private String name;
    
    private LocalDate date;
    
    @ManyToOne
    @JoinColumn(name = "id_upper_category")
    private Category categoryUpper;
    
    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

}
