package javafx.incidentmanager.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;


@Entity
@Table
@Data
public class Incident {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Service service;
    
    @ManyToOne
    private Client clients;
    
    @Column(name = "stimated_date")
    private LocalDate stimatedDate;
    
    @Column(name = "entry_date")
    private LocalDate entryDate;
    
    @Column(name = "real_finish_date")
    private LocalDate realFinishDate;
    
    private String description;
    
    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
    private List<Notification> notifications;
    
    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
    private List<Problem> problems;
    
    //private State state;
    
    
    
}
