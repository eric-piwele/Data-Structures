package piwele.adt;

public interface ListAdt<T> extends Iterable<T>{
    void add(T element, int index);
    Boolean add(T t);
    Boolean contains(T t);
    T remove(int index);
    Boolean isEmpty();
    Integer size();
    void clear();
}
