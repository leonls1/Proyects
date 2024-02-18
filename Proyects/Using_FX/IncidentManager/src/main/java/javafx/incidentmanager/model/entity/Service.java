package javafx.incidentmanager.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter@Setter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private List<Incident> incidents;

    public Service() {
    }

    public Service(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", description=" + description + '}';
    }
    
    
    
}
