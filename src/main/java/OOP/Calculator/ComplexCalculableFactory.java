package OOP.Calculator;

public class ComplexCalculableFactory<E> implements ICalculableFactory<E>{

    @Override
    public Calculable create(E primaryArg) {
        return new ComplexCalculator((ComplexNum) primaryArg);
    }
}
