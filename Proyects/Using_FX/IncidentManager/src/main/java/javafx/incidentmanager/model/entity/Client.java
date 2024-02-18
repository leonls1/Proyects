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
import javafx.incidentmanager.model.enums.CorporateName;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter@Setter
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
    
    @OneToMany(mappedBy = "clients", cascade = CascadeType.ALL)
    private List<Incident> incidents;

    public Client() {
    }

    public Client(String Cuil_Cuit, Long phoneNumber, String email, CorporateName corporateName) {
        this.Cuil_Cuit = Cuil_Cuit;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.corporateName = corporateName;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", Cuil_Cuit=" + Cuil_Cuit + ", phoneNumber=" + phoneNumber + ", email=" + email + ", corporateName=" + corporateName + '}';
    }

 
    
    
    
}
