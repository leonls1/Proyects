package project.commandmanager.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
@Table
public class Street {

    private String name;    
    
    private String stree_number;
    
     
    private boolean isDeleted;
   
    
    @OneToMany(mappedBy = "street")
    private List<Purchase> purchases;
}
