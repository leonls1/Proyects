package project.trainerview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import project.trainerview.model.entities.User;
import project.trainerview.model.persistence.UserDAO;
import project.trainerview.utilities.factories.DAOFactory;

public class UserService {

    UserDAO dao = DAOFactory.geUserDAO();
    RutineService rutineService = new RutineService();
    
    public List<User> filterUser(String word) {
        List<User> list = new ArrayList<>();

        dao.getAll().stream().forEach(elem -> {
            if (elem.getId().toString().contains(word) ||
                    elem.getName().toLowerCase().contains(word) ||
                    elem.getSurname().toLowerCase().contains(word)) {
                list.add(elem);
            }
        });
        return list;

    }

    public static User searchUserByWord(String word) {
        User user = new User();
        return user;

    }

    public UserDAO getDao() {
        return dao;
    }
    
    public void deleteUser(User user){
        rutineService.deleteRutine(user.getRutine());
        dao.delete(user);
    }
    
    
}
