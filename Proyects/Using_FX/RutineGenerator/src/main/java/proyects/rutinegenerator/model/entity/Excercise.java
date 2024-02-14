package proyects.rutinegenerator.model.entity;


import java.io.Serializable;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Excercise implements Serializable{
   private static final Long SerialVersionUID = 1L;
    
   private String name;
   
   private String muscle;
   

    public Excercise(String name, String ubicacion) {
        this.name = name;
        this.muscle = ubicacion;
    }
 
    public Excercise() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Excercise other = (Excercise) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Excercise{" + "name = " + name + ", Muscle = " + muscle + '}' + "\n";
    }
    
    
   
    
   
   
   
}
