package dynamic_array;

import jdk.nashorn.internal.ir.IfNode;

import java.awt.dnd.InvalidDnDOperationException;

/**
 * USER:wbpjgs
 * TOTO:循环单链表
 * CLASSNAME: LinkedList
 * DATE: 2020/4/29
 * TIME: 23:33
 * VERSION:1.0.0
 * JDK 1.8
 */

public class SingleCircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    private static class Node<E> {
        private E element;
        private Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(element + "->" + this.next.element);
            return sb.toString();
        }
    }

    /**
     * 循环单向链表添加
     *
     * @param index
     * @param elelment
     */
    @Override
    public void add(int index, E elelment) {
        rangeCheckFor(index);
        if (index == 0) {

            first = new Node<>(elelment, first);
            Node<E> last = (size == 0) ? first : getNode(size);
            last.next = first;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = new Node<>(elelment, prev.next);
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
        size = 0;
    }

    /**
     * 单向循环表链移除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            if (size == 1) //当index == 0 只有一个元素的时候移除
            {
                first = null;
            } else // //当index == 0 size > 1 的时候移除
            {
                final Node<E> last = getNode(size - 1);
                first = first.next;
                last.next = first;
            }
        } else {
            Node<E> previ = getNode(index - 1);
            node = previ.next;
            previ.next = node.next;
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
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
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
        //输出每个元素的下一项
        sb.append("\n");
        sb.append("size=").append(size + ",").append("elements[");
        Node<E> node1 = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(node1);
            node1 = node1.next;
        }
        sb.append("]");

        return sb.toString();
    }
}
