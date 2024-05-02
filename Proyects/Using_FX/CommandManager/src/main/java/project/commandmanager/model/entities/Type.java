package project.commandmanager.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter
@Table
@Entity
public class Type {

    private Long id;
    
    private String description;
    
    @OneToMany(mappedBy = "type")
    private List<Item> items;
}
