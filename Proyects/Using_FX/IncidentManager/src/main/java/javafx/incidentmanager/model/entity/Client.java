package javafx.incidentmanager.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import javafx.incidentmanager.model.satellite.CorporateName;
import lombok.Data;
import java.util.List;

@Entity
@Table
@Data
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String Cuil_Cuit;
    
    @Column(name = "phone_number")
    private Long phoneNumber;
    
    private String email;
    
    @Enumerated(value = EnumType.STRING)
    private CorporateName corporateName;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Incident> incidents;
}
