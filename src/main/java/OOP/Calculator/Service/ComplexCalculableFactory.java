package OOP.Calculator.Service;

import OOP.Calculator.ComplexNum;

public class ComplexCalculableFactory<E> implements ICalculableFactory<E>{

    @Override
    public Calculable create(E primaryArg) {
        return new ComplexCalculator((ComplexNum) primaryArg);
    }
}
