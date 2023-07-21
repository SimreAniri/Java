package OOP.S4;

import java.util.List;

public class Calculator {
    public double mult(List<? extends Number> nums) {
        double result = 1.0;
        for (Number num: nums) {
            result *= num.doubleValue();
        }
        return result;
    }
    public double div(Number a, Number b) {
        return a.doubleValue() / b.doubleValue();
    }

//    public String decToBin(Number a){
//        return result;
//    }
}
