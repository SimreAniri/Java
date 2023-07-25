package OOP.S5.model;

public class Student extends User{
    int studentId;

    public Student(String name, String surname, String patron, int studentId) {
        super(name, surname, patron);
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patron='" + patron + '\'' +
                '}';
    }
}
