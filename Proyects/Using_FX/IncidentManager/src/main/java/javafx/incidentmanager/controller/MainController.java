package javafx.incidentmanager.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.incidentmanager.model.dao.IncidentDao;
import javafx.incidentmanager.model.dao.ServiceDao;
import javafx.incidentmanager.model.entity.*;
import javafx.incidentmanager.model.enums.*;
import javafx.incidentmanager.model.statePattern.Started;
import javafx.incidentmanager.service.ClientService;
import javafx.incidentmanager.service.TechService;
import javafx.incidentmanager.utilities.converter.ServiceConverter;
import javafx.incidentmanager.utilities.converter.TechConverter;
import javafx.incidentmanager.utilities.factories.DAOFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
    
    private IncidentDao incidentService;

    private TechService techService;

    private ServiceDao serviceService;

    private ClientService clientService;

    private Client client;

    private List<Employee> techList;

    private Incident incident;

    @FXML
    private Button btnLogInCustomer, btnSaveIncident, btnSearchTech;

    @FXML
    private TextField txtfCUIL;

    @FXML
    private TextArea txtADescription;

    @FXML
    private ComboBox cboServices, cboAvaliablesTechnicians;

    @FXML
    private ComboBox<CorporateName> cboCorporateName;

    @FXML
    private ComboBox<ProblemType> cboProblemType;

    @FXML
    private void btnAction(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(btnLogInCustomer)) {
            findUser();
        } else if (evt.equals(btnSaveIncident)) {
            saveIncident();

        } else if (evt.equals(btnSearchTech)) {
            searchTechs();
        }
    }

    @FXML
    private void cboAction(ActionEvent event) {
        Object evt = event.getSource();

        if (evt.equals(cboAvaliablesTechnicians)) {

        } else if (evt.equals(cboProblemType)) {

        } else if (evt.equals(cboServices)) {

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        techService = new TechService();
        serviceService = DAOFactory.getServiceDao();
    }

    //--------------------------------------Interface methods ---------------------------------------//
    public void loadCBOTechs() {
        cboAvaliablesTechnicians.setItems(FXCollections.observableArrayList(techList));
        TechConverter converter = new TechConverter(cboAvaliablesTechnicians);
        cboAvaliablesTechnicians.setConverter(converter);
        
        cboAvaliablesTechnicians.getSelectionModel().selectFirst();
    }

    public void loadCBOServices() {
        cboServices.setItems(FXCollections.observableArrayList(serviceService.GetAll()));
        ServiceConverter converter = new ServiceConverter(cboServices);
        cboServices.setConverter(converter);

    }

    public void loadCBOTypes_CorporateName() {

        //loading and selecting the firts corporate name by default
        cboCorporateName.setItems(FXCollections.observableArrayList(CorporateName.values()));
        cboCorporateName.getSelectionModel().selectFirst();

        //same ad before with problemType
        cboProblemType.setItems(FXCollections.observableArrayList(ProblemType.values()));
        cboProblemType.getSelectionModel().selectFirst();

    }

    //-------------------------------------Data Methods----------------------------------------------//
    private void findUser() {
        //getting all users with the corporateName selected
        List<Client> userByCorporateName = clientService.filterClientsByCorporateName(cboCorporateName.getSelectionModel().getSelectedItem());
        client = clientService.findByCuil_Cuit(txtfCUIL.getSelectedText(), userByCorporateName);
        if (client != null) {

            cboServices.setDisable(false);
        } else {
            System.out.println("error, no existe el cleinte con ese cuil/cuit");
        }

    }

    private void searchTechs() {
        techList = techService.getAllTechs();
        cboAvaliablesTechnicians.setDisable(false);

    }

    private void saveIncident() {
        if (!txtADescription.getText().isBlank()) {
            incident = new Incident();
            incident.setClients(client);
            incident.setDescription(txtADescription.getText());
            incident.setEntryDate(LocalDate.now());
            incident.setService((Service)cboServices.getSelectionModel().getSelectedItem());
            incident.setState(new Started());
            incident.setStimatedDate(LocalDate.now().plusDays(7));
            
            incidentService.create(incident);
        } else {
            System.out.println("La descripcion del incidente no puede estar en blanco");
        }
    }

}
