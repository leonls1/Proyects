package project.commandmanager.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import project.commandmanager.model.enums.PaymentType;

@Table
@Entity
@Getter
@Setter
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private float totalAmount;
     
    private boolean isDeleted;
   
    
    @ManyToOne
    private Command command;
    
    @ManyToOne
    private Street street;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetail> details;
    
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

}
