package dynamic_array;

import java.util.concurrent.ForkJoinPool;

/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: CircleDeque
 * DATE: 2020/5/5
 * TIME: 19:18
 * VERSION:1.0.0
 * JDK 1.8
 */
public class CircleDeque<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int front;
    private E[] elements;

    public CircleDeque() {
        this(DEFAULT_CAPACITY);
    }

    public CircleDeque(int capaticy) {
        int initCapacity = capaticy > DEFAULT_CAPACITY ? capaticy : DEFAULT_CAPACITY;
        elements = (E[]) new Object[initCapacity];
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取队列大小
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * 清空队列
     */
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        front = 0;
        size = 0;
    }

    /**
     * 头部入队列
     *
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        elements[index(-1)] = element;
        front = index(-1);
        size ++;
    }

    /**
     * 尾部入队列
     *
     * @param element
     */
    public void enQueuerear(E element) {
        ensureCapacity(size +1);
        elements[index(size)] = element;
        size ++;
    }

    /**
     * 头部出队列
     *
     * @return E
     */
    public E deQueueFront() {
        E element = elements[front++];
        size --;
        return element;
    }

    /**
     * 尾部出队列
     *
     * @return E
     */
    public E deQueueRear() {
        E element = elements[index(size-1)];
        size--;
        return element;
    }

    /**
     * 获取头部元素
     *
     * @return E
     */
    public E front() {
        return elements[front];
    }

    /**
     * 获取尾部元素
     *
     * @return E
     */
    public E rear() {
        return elements[index(size-1)];
    }

    //数组中操作侧索引和实际索引做一个转换
    private int index(int index) {
        int realIndex = index + front;
        if (realIndex < 0) {
            realIndex = realIndex + elements.length;
        }
        return realIndex % elements.length;
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
