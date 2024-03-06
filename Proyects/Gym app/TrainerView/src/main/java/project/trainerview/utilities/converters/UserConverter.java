package project.trainerview.utilities.converters;

import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import project.trainerview.model.entities.User;

public class UserConverter extends StringConverter<User> {

    private ComboBox<User> cbo;

    public UserConverter(ComboBox<User> cbo) {
        this.cbo = cbo;
    }

    @Override
    public String toString(User user) {
        return user != null ? (user.getName() + ", " + user.getSurname() + " - " + user.getId()) : null;
    }

    @Override
    public User fromString(String string) {
        User user = this.cbo.getSelectionModel().getSelectedItem();

        return user;
    }

}
