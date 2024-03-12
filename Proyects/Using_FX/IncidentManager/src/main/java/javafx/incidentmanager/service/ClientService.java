package javafx.incidentmanager.service;

import java.util.List;
import java.util.stream.Collectors;
import javafx.incidentmanager.model.dao.ClientDao;
import javafx.incidentmanager.model.entity.Client;
import javafx.incidentmanager.model.enums.CorporateName;
import javafx.incidentmanager.utilities.factories.DAOFactory;

public class ClientService {

    private ClientDao dao;

    public Client findByCuil_Cuit(String cuilCuil, List<Client> list) {
        Client cli = null;

        for (Client client : list) {
            if (client.getCuil_Cuit().equals(cuilCuil)) {
                cli = client;
                break;
            }
        }
        return cli;
    }
    
    public List<Client> filterClientsByCorporateName(CorporateName corporateName){
        return dao.GetAll().
                stream().
                filter(cli -> cli.getCorporateName().equals(corporateName)).
                collect(Collectors.toList())
                ;
    }

    public ClientService() {
        this.dao = DAOFactory.getClientDao();
    }

}
