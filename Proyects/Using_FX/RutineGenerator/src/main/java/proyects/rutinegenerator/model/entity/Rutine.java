package proyects.rutinegenerator.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rutine implements Serializable {

    private static final Long SerialVersionUID = 1L;

    private String name;

    private List<SubRutine> subRutines = new ArrayList<>();

    private String level;

    private String type;

    private int days;

    private String Distribution;

    public Rutine(String name, String level, String type, int days, String Distribution,List<SubRutine> subrutines) {
        this.name = name;
        this.level = level;
        this.type = type;
        this.days = days;
        this.Distribution = Distribution;
    }
    
    

    public Rutine() {
    }

    @Override
    public String toString() {
        return "Rutine{" + "name=" + name + ", subRutines=" + subRutines + '}';
    }

}
