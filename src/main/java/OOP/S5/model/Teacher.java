package OOP.S5.model;

public class Teacher extends User {
    int teacherId;

    public Teacher(String name, String surname, String patron, int teacherId) {
        super(name, surname, patron);
        this.teacherId = teacherId;
    }
}
