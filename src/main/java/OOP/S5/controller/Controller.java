package OOP.S5.controller;

import OOP.S5.model.Student;
import OOP.S5.model.Teacher;
import OOP.S5.model.Type;
import OOP.S5.model.User;
import OOP.S5.service.UserService;
import OOP.S5.view.StudentView;
import OOP.S5.view.TeacherView;

import java.util.List;

public class Controller {
    private final UserService service = new UserService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();

    public void createStuden(String name, String surname, String patron) {
        service.create(name, surname, patron, Type.STUDENT);
    }

    public void createTeacher(String name, String surname, String patron) {
        service.create(name, surname, patron, Type.TEACHER);
    }

    public void getAllStudent() {
        List<User> studentList = service.readOnlyStudent();
        for (User user : studentList) {
            Student student = (Student) user;
            studentView.printConsole(student);
        }
    }
    public void getAllTeacher() {
        List<User> teacherList = service.readOnlyTeachers();
        for (User user : teacherList) {
            Teacher teacher = (Teacher) user;
            teacherView.printConsole(teacher);
        }
    }
}
