package javafx.incidentmanager.utilities.converter;


import javafx.incidentmanager.model.entity.Service;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;


public  class ServiceConverter extends StringConverter<Service>{

    private ComboBox<Service> cbo;

    public ServiceConverter(ComboBox<Service> cbo) {
        this.cbo = cbo;
    }
    
    
    
    @Override
    public String toString(Service service) {
        return service != null ? service.getDescription() : null;
    }

    @Override
    public Service fromString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

