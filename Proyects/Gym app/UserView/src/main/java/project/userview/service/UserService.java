package project.userview.service;

import java.util.ArrayList;
import java.util.List;
import project.userview.model.entities.User;
import project.userview.model.persistence.UserDAO;
import project.userview.utilities.factories.DAOFactory;

public class UserService {

    UserDAO dao = DAOFactory.geUserDAO();

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
    
    
}
