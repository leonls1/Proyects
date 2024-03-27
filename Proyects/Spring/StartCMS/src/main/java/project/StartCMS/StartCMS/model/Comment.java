package project.StartCMS.StartCMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table
@Getter@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String comment;
    
    @ManyToOne    
    @JoinColumn(name = "id_post")
    private Post post;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    private LocalDate date;
    
    private String response;
}
