package dynamic_array;

/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: List
 * DATE: 2020/4/29
 * TIME: 23:16
 * VERSION:1.0.0
 * JDK 1.8
 */
public interface List<E> {
    int ELEMENT_NOT_FOUND = -1;

    int size();

    boolean isEmpty();

    boolean contains(E element);

    void add(E elelment);

    void add(int index, E elelment);

    E get(int index);

    void clear();

    E remove(int index);

    int indexOf(E element);

    E set(int index, E element);
}
