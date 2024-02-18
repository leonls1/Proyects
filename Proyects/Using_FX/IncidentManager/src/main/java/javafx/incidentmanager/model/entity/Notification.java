package javafx.incidentmanager.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import javafx.incidentmanager.model.enums.ContactType;
import lombok.Data;

@Entity
@Table
@Data
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Incident incident;
    
    private String description;
    
    @Enumerated(value = EnumType.STRING)
    private ContactType contactType;
    
    private String contact;

    public Notification() {
    }

    public Notification(Incident incident, String description, ContactType contactType, String contact) {
        this.incident = incident;
        this.description = description;
        this.contactType = contactType;
        this.contact = contact;
    }


    
    
    
}
