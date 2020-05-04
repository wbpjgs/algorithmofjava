package dynamic_array;

/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: LinkedList
 * DATE: 2020/4/29
 * TIME: 23:33
 * VERSION:1.0.0
 * JDK 1.8
 */
public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    private static class Node<E> {
        private E element;
        private Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void add(int index, E elelment) {
        rangeCheckFor(index);
        if (index == 0) {
          first = new Node<E>(elelment, null);
        } else {
            Node<E> previ = getNode(index - 1);
            previ.next = new Node<>(elelment, null);
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

    @Override
    public E remove(int index) {
        Node<E> node = first;
        if (index == 0) {
            first = first.next;
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
        return sb.toString();
    }
}
