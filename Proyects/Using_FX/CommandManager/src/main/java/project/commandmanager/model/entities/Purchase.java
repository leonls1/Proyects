package project.commandmanager.model.entities;

import jakarta.persistence.Entity;
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
    
    @ManyToOne
    private Command command;
    
    @ManyToOne
    private Street street;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseDetail> details;

    public void calculateTotalAmount() {
        totalAmount = 0;
        details.forEach(detail -> totalAmount
                += detail.getAmount());
    }

    public Purchase() {
    }

    
}
