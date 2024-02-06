package proyects.rutinegenerator.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rutine implements Serializable{
    
    private static final Long SerialVersionUID = 1L;
    
    private String name;   
    
    private List<SubRutine> subRutines = new ArrayList<>(); 

    public Rutine() {
    }

    public Rutine(String name, List<SubRutine> subRutines) {
        this.name = name;
        this.subRutines = subRutines;
    }

    @Override
    public String toString() {
        return "Rutine{" + "name=" + name + ", subRutines=" + subRutines + '}';
    }
    
    
    
    
}
