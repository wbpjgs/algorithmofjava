package dynamic_array;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.PipedReader;
import java.util.Arrays;

/**
 * USER:wbpjgs
 * TOTO:动态数组实现
 * CLASSNAME: ArrayList
 * DATE: 2020/4/18
 * TIME: 23:51
 * VERSION:1.0.0
 * JDK 1.8
 */
public class ArrayList<E> extends AbstractList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    private E[] elements;


    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size - 1; i++) {
                if (elements[i] == null) {
                    return i;
                }

            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        if (index > 0 && index < size) {
            elements[index] = element;
        }
        return old;
    }

    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }


    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void add(int index, E element) {
        rangeCheckFor(index);
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(int size) {
        if (size < elements.length) {
            return;
        } else {
            int oldCapacity = elements.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            E[] newElements = (E[]) new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
            System.out.println(oldCapacity + " 扩容到 " + newCapacity);
        }
    }

    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i <= size - 1; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;

        trim();
        return old;
    }

    //减容
    private void trim() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;
        if (size > newCapacity || newCapacity < DEFAULT_CAPACITY) {
            return;
        }

        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + " 减容到 " + newCapacity);
    }

    public void remove(E elements) {
        remove(indexOf(elements));
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size + ",").append("elements[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }


}
