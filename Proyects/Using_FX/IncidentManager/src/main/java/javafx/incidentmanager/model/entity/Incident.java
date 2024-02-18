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
import lombok.Getter;
import lombok.Setter;


@Entity
@Table
@Getter@Setter
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

    public Incident() {
    }

    public Incident(Service service, Client clients, LocalDate stimatedDate, LocalDate entryDate, LocalDate realFinishDate, String description) {
        this.service = service;
        this.clients = clients;
        this.stimatedDate = stimatedDate;
        this.entryDate = entryDate;
        this.realFinishDate = realFinishDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Incident{" + "id=" + id + ", service=" + service + ", clients=" + clients + ", stimatedDate=" + stimatedDate + ", entryDate=" + entryDate + ", realFinishDate=" + realFinishDate + ", description=" + description + '}';
    }

    
    
    
    
}
