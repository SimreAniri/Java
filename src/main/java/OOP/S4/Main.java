package OOP.S4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int a = 10;
        double b = 2.0;

        System.out.println(a + b);

        System.out.println("calc.mult(Arrays.asList(a, b)) = " + calc.mult(Arrays.asList(a, b)));
        System.out.println("calc.div(a, b) = " + calc.div(a, b));
    }

}
