package OOP.S5.service;

import OOP.S5.model.Type;
import OOP.S5.model.User;

import java.util.List;

public interface DataService {
    void create(String name, String surname, String patron, Type type);

    List<User> read();

    List<User> readOnlyStudent();
}
