package javafx.incidentmanager.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table(name = "specialty")
public class Specialty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Column(name = "name", nullable = false)
    private String name;    
    
    @ManyToMany(mappedBy = "specialties")
    private Set<Employee> employees;
    
    @ManyToMany
    private Set<Problem> problems;

    public Specialty() {
    }

    public Specialty(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialty{" + "Id=" + Id + ", name=" + name + '}';
    }

    
    
}
