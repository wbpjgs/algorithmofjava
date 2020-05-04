package dynamic_array;

import java.lang.invoke.LambdaConversionException;
import java.util.IdentityHashMap;

/**
 * USER:wbpjgs
 * TOTO:双向链表
 * CLASSNAME: DoubleLinkedList
 * DATE: 2020/5/4
 * TIME: 8:54
 * VERSION:1.0.0
 * JDK 1.8
 */
public class DoubleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> tail;

    private static class Node<E> {
        private E element;
        private Node next;
        private Node previ;

        public Node(Node previ, E element, Node next) {
            this.previ = previ;
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void add(int index, E elelment) {
        rangeCheckFor(index);
        if (index == size) {
            Node<E> oldTail = tail;
            tail = new Node<>(oldTail, elelment, null);
            if (oldTail == null) //大小为0时在末尾插入元素
            {
                first = tail;
            } else  // 大小不为0时在末尾插入元素
            {
                oldTail.next = tail;
            }

        } else {
            Node<E> next = getNode(index);
            Node<E> prev = next.previ;
            Node<E> node = new Node<>(prev, elelment, next);
            if (prev == null) // 插入在0位置
            {
                first = node;
            } else //插入在中间位置
            {
                prev.next = node;
            }
            next.previ = node;
        }

        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public void clear() {
        first = null;
        tail = null;
        size = 0;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNode(index);
        Node<E> prev = node.previ;
        Node<E> next = node.next;
        if (prev == null) //index == 0
        {
            first = next;
        } else {
            prev.next = next;
        }
        if (next == null) // index == size - 1
        {
            tail = prev;
        } else {
            next.previ = prev;
        }


        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (first.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (first.element.equals(element)) {
                    return i;
                }
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    @Override
    public E set(int index, E element) {
        E oldElement = null;
        if (index == 0) {
            oldElement = first.element;
            first.element = element;
        } else {
            oldElement = getNode(index).element;
            getNode(index).element = element;

        }
        return oldElement;
    }

    //取节点
    private Node<E> getNode(int index) {
        if (index < size >> 1) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.previ;
            }
            return node;

        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size + ",").append("elements[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(node.element);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
