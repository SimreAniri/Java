package OOP.Calculator;

public interface Calculable<E> {
    Calculable<E> sum(E arg);
    Calculable<E> multi(E arg);
    E getResult();
}
