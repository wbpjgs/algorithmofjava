package dynamic_array;

/**
 * USER:wbpjgs
 * TOTO:双向循环链表
 * CLASSNAME: DoubleLinkedList
 * DATE: 2020/5/4
 * TIME: 8:54
 * VERSION:1.0.0
 * JDK 1.8
 */
public class DoubleCircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> tail;
    private Node<E> current;

    private static class Node<E> {
        private E element;
        private Node next;
        private Node previ;

        public Node(Node previ, E element, Node next) {
            this.previ = previ;
            this.element = element;
            this.next = next;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.previ.element).append("<-").append(this.element).append("->").append(this.next.element);
            return sb.toString();
        }
    }

    @Override
    public void add(int index, E elelment) {
        rangeCheckFor(index);
        if (index == size) {
            Node<E> oldTail = tail;
            tail = new Node<>(oldTail, elelment, first);
            if (oldTail == null) //大小为0时在末尾插入元素
            {
                first = tail;
                first.next = first;
                first.previ = first;
            } else  // 大小不为0时在末尾插入元素
            {
                oldTail.next = tail;
                first.previ = tail;
            }

        } else {
            Node<E> next = getNode(index);
            Node<E> prev = next.previ;
            Node<E> node = new Node<>(prev, elelment, next);
            prev.next = node;
            if (next == first) // 插入在0位置
            {
                first = node;
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
        final Node<E> node = getNode(index);
        return remove(node);
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


    /**
     * 循环链表让current指向first
     */
    public void reset() {
        current = first;
    }

    /**
     * 循环列表指针向后移
     */
    public void next() {
        current = current.next;
    }

    /**
     * 删除当前元素
     *
     * @return
     */
    public E remove() {
        Node<E> next = current.next;
        E element = remove(current);
        if (size == 0) {
            current = null;
        } else {
            current = next;
        }
        return element;
    }

    private E remove(Node<E> node) {
        if (size == 1) {
            first = null;
            tail = null;
        } else {
            Node<E> prev = node.previ;
            Node<E> next = node.next;
            prev.next = next;
            next.previ = prev;
            if (node == first) //index == 0
            {
                first = next;
            }
            if (node == tail) // index == size - 1
            {
                tail = prev;
            }
        }
        size--;
        return node.element;
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
        sb.append("\n");
        //表示每个元素的前驱元素和后驱元素
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
