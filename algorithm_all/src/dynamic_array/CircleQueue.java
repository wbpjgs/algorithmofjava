package dynamic_array;

/**
 * USER:wbpjgs
 * TOTO:循环队列
 * CLASSNAME: CircleQueue
 * DATE: 2020/5/5
 * TIME: 17:54
 * VERSION:1.0.0
 * JDK 1.8
 */
public class CircleQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int front;
    private E[] elements;

    public CircleQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircleQueue(int capaticy) {
        int initCapacity = capaticy > DEFAULT_CAPACITY ? capaticy : DEFAULT_CAPACITY;
        elements = (E[]) new Object[initCapacity];
    }

    /**
     * 清空队列
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        front = 0;
        size = 0;
    }

    /**
     * 返回队列大小
     */
    public int size() {
        return size;
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 元素入队
     *
     * @param element
     */
    public void enQueue(E element) {
        ensureCapacity(size +1);
        if (size >= elements.length) {
            throw new RuntimeException("queue size = " + size + ", capacity = " + elements.length + ",not add element.");
        }
        elements[index(size)] = element;
        size++;
    }

    /**
     * 元素出队
     *
     * @return E
     */
    public E deQueue() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * 探测队头元素
     *
     * @return E
     */
    public E peek() {
        return elements[front];
    }

    //数组中操作侧索引和实际索引做一个转换
    private int index(int index) {
        return (index + front) % elements.length;
    }

    //对数组容量进行扩容
    private void ensureCapacity(final int capacity) {
        if (capacity < elements.length) return;
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        front = 0;
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=" + size).append("[");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
