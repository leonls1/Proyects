package proyects.rutinegenerator.model.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubRutine implements Serializable{
   private static final Long SerialVersionUID = 1L;
    private Excercise excercise;

    private int series;

    private int repetitions;
    
    private int day;

    public SubRutine() {
    }

    public SubRutine(Excercise excercise, int series, int repetitions,int day) {
        this.excercise = excercise;
        this.series = series;
        this.repetitions = repetitions;
        this.day = day;
    }

    @Override
    public String toString() {
        return "SubRutine{" + "excercise=" + excercise + ", series=" + series + ", repetitions=" + repetitions + '}' + "\n";
    }

}
