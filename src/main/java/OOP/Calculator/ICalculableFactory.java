package OOP.Calculator;

public interface ICalculableFactory<E> {
    Calculable<E> create(E primaryArg);
}
