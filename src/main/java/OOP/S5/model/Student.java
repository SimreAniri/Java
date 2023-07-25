package OOP.S5.model;

public class Student extends User{
    String studentId;
    static int countStudent = 0;

    public Student(String name, String surname, String patron) {
        super(name, surname, patron);
        countStudent++;
        studentId = "St" + countStudent;
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
