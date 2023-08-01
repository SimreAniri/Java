package OOP.Calculator.Service;

public interface Calculable<E>{
    Calculable sum(E arg);
    Calculable multi(E arg);
    E getResult();
}
