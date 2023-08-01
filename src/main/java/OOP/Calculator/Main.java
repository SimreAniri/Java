package OOP.Calculator;

// Создать логирование операций, для класса Calculator. Класс Calculator не должен изменится.
public class Main {
    public static void main(String[] args) {
        ICalculableFactory intCalculableFactory = new IntCalculableFactory();
        ViewCalculator view1 = new ViewCalculator(intCalculableFactory);
        view1.run();
    }
}
