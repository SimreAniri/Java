package OOP.Calculator.Service;

public interface ICalculableFactory<E> {
    Calculable<E> create(E primaryArg);
}
