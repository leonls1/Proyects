package javafx.incidentmanager.utilities.converter;

import javafx.incidentmanager.model.entity.Employee;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;

public class TechConverter extends StringConverter<Employee> {

    private ComboBox<Employee> cbo;

    public TechConverter(ComboBox<Employee> cbo) {
        this.cbo = cbo;
    }

    @Override
    public String toString(Employee emp) {
        return emp != null ? (emp.getName() + " " + emp.getSurname()) : null;
    }   

    @Override
    public Employee fromString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
