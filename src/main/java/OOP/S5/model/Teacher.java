package OOP.S5.model;

public class Teacher extends User {
    String teacherId;
    static int countTeacher = 0;

    public Teacher(String name, String surname, String patron) {
        super(name, surname, patron);
        countTeacher++;
        teacherId = "St" + countTeacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patron='" + patron + '\'' +
                '}';
    }
}
