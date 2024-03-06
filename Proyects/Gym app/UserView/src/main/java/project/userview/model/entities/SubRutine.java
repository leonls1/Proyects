package project.userview.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table
@Getter@Setter
public class SubRutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String excercise;

    private int series;

    //private int repetitions;
    private String repetitions;
    
    private int day;
    
    @ManyToOne
    private Rutine rutine;

    @Override
    public String toString() {
        return "SubRutine{" + "id=" + id + ", excercise=" + excercise + ", series=" + series + ", repetitions=" + repetitions + ", day=" + day + '}';
    }
    
    
}
