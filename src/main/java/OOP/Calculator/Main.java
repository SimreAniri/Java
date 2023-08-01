package OOP.Calculator;

import OOP.Calculator.Service.ComplexCalculableFactory;
import OOP.Calculator.Service.ICalculableFactory;
import OOP.Calculator.Service.IntCalculableFactory;
import OOP.Calculator.View.ViewCalculator;
import OOP.Calculator.View.ViewComplexCalculator;

// Создать логирование операций, для класса Calculator. Класс Calculator не должен изменится.
public class Main {
    public static void main(String[] args) {
        System.out.println("Калькулятор");
        ICalculableFactory intCalculableFactory = new IntCalculableFactory();
        ViewCalculator view1 = new ViewCalculator(intCalculableFactory);
        view1.run();

        System.out.println("\nКалькулятор комплексных чисел");
        ICalculableFactory complexCalculableFactory = new ComplexCalculableFactory();
        ViewComplexCalculator view2 = new ViewComplexCalculator(complexCalculableFactory);
        view2.run();
    }
}
