package proyects.rutinegenerator.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubRutine {

    private Excercise excercise;

    private int series;

    private int repetitions;

    public SubRutine() {
    }

    public SubRutine(Excercise excercise, int series, int repetitions) {
        this.excercise = excercise;
        this.series = series;
        this.repetitions = repetitions;
    }

    @Override
    public String toString() {
        return "SubRutine{" + "excercise=" + excercise + ", series=" + series + ", repetitions=" + repetitions + '}' + "\n";
    }

}
