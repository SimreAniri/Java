package OOP.S5.service;

import OOP.S5.model.Student;
import OOP.S5.model.Teacher;
import OOP.S5.model.Type;
import OOP.S5.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements DataService {

    private List<User> userList = new ArrayList<>();

    @Override
    public void create(String name, String surname, String patron, Type type) {
        if (Type.STUDENT == type) {
            Student student = new Student(name, surname, patron);
            userList.add(student);
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(name, surname, patron);
            userList.add(teacher);
        }
    }


    @Override
    public List<User> read() {
        return userList;
    }

    @Override
    public List<User> readOnlyStudent() { //принцип единой ответственности
        List<User> students = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Student) {
                students.add(user);
            }
        }
        return students;
    }

    @Override
    public List<User> readOnlyTeachers() { //принцип единой ответственности
        List<User> teachers = new ArrayList<>();
        for (User user : userList) {
            if (user instanceof Teacher) {
                teachers.add(user);
            }
        }
        return teachers;
    }
}
