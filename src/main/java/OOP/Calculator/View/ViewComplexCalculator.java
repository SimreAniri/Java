package OOP.Calculator.View;

import OOP.Calculator.Service.Calculable;
import OOP.Calculator.ComplexNum;
import OOP.Calculator.Service.ICalculableFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViewComplexCalculator {
    private ICalculableFactory calculableFactory;

    public ViewComplexCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void run() {
        while (true) {
            List<String> primaryArgs = promptStr("Введите первый аргумент в формате Re Im: ");
            Calculable calculator = calculableFactory.create(new ComplexNum(Double.parseDouble(primaryArgs.get(0)),
                    Double.parseDouble(primaryArgs.get(1))));
            while (true) {
                String cmd = prompt("Введите команду (*, +, =) : ");
                if (cmd.equals("*")) {
                    List<String> args = promptStr("Введите второй аргумент в формате Re Im: ");
                    calculator.multi(new ComplexNum(Double.parseDouble(args.get(0)),
                            Double.parseDouble(args.get(1))));
                    continue;
                }
                if (cmd.equals("+")) {
                    List<String> args = promptStr("Введите второй аргумент в формате Re Im: ");
                    calculator.sum(new ComplexNum(Double.parseDouble(args.get(0)),
                            Double.parseDouble(args.get(1))));
                    continue;
                }
                if (cmd.equals("=")) {
                    Object result = calculator.getResult();
                    System.out.printf("Результат " + result);
                    break;
                }
            }
            String cmd = prompt("\nЕще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private List<String> promptStr(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Arrays.asList(in.nextLine().split(" "));
    }
}
