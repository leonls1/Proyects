package javafx.incidentmanager.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import javafx.incidentmanager.model.enums.ProblemType;
import lombok.Data;
import java.util.Set;

@Entity
@Table
@Data
public class Problem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Incident incident;
    
    @ManyToMany(mappedBy = "problems")
    private Set<Specialty> specialties;
    
    @Enumerated(value = EnumType.STRING)
    private ProblemType type;
    
    private String description;
    
    @Column(name = "stimated_time")
    private int stimatedTime;

    public Problem() {
    }

    public Problem(Incident incident, ProblemType type, String description, int stimatedTime) {
        this.incident = incident;
        this.type = type;
        this.description = description;
        this.stimatedTime = stimatedTime;
    }


    
    
}
