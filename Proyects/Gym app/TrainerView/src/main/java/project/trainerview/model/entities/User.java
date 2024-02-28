package project.trainerview.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter@Setter
public class User {

    @Id
    private Long id;
    
    private String name;
    
    private String surname;
    
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    
    @OneToOne(mappedBy = "user")
    private Rutine rutine;
}
