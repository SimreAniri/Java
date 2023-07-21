package OOP.S4;

import java.util.List;

public class Calculator {
    public double mult(List<? extends Number> nums) {
        double result = 1.0;
        for (Number num : nums) {
            result *= num.doubleValue();
        }
        return result;
    }

    public double div(Number a, Number b) {
        return a.doubleValue() / b.doubleValue();
    }

    public String decToBin(Number num) {
        String result;

        if (num instanceof Integer) {
            result = intDecToBin(num.intValue());
        } else result = decToBin(String.valueOf(num));

        return result;
    }

    public String decToBin(String num) {
        String result;

        if (num.contains(".")) {
            int iPoint = num.indexOf('.');

            result = intDecToBin(Integer.parseInt(num.substring(0, iPoint))) + ".";
            result += decimalDecToBin(Double.parseDouble("0" + num.substring(iPoint)));
        } else result = intDecToBin(Integer.parseInt(num));
        return result;
    }

    private String intDecToBin(int num) {
        String result = "";
        int temp;

        while (num != 0) {
            temp = num % 2;
            result = temp + result;
            num = (num - temp) / 2;
        }
        return result;
    }

    private String decimalDecToBin(double num) {
        String result = "";
        int temp;

        for (int i = 1; i < 3; i++) {
            num *= 2;
            temp = (int) num;
            result += temp;
            num -= temp;
        }
        return result;
    }
}
