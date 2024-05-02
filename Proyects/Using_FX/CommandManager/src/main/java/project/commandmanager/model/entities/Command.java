package project.commandmanager.model.entities;

import jakarta.persistence.OneToMany;
import java.util.List;


public class Command {

    private Long id;
    
    @OneToMany(mappedBy = "command")
    private List<Purchase> purchases;
    
    
}
