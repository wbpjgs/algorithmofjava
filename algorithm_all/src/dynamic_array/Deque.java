package dynamic_array;

import java.io.PipedReader;
import java.lang.annotation.ElementType;

/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: Deque
 * DATE: 2020/5/5
 * TIME: 11:56
 * VERSION:1.0.0
 * JDK 1.8
 */
public class Deque<E> {
    private List<E> list = new DoubleLinkedList<>();

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 获取队列大小
     *
     * @return int
     */
    public int size() {
        return list.size();
    }

    /**
     * 清空队列
     */
    public void clear() {
        list.clear();
    }

    /**
     * 头部入队列
     *
     * @param element
     */
    public void enQueueFront(E element) {
        list.add(0, element);
    }

    /**
     * 尾部入队列
     *
     * @param element
     */
    public void enQueuerear(E element) {
        list.add(element);
    }

    /**
     * 头部出队列
     *
     * @return E
     */
    public E deQueueFront() {
        return list.remove(0);
    }

    /**
     * 尾部出队列
     *
     * @return E
     */
    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }
    /**
     * 获取头部元素
     * @return E
     */
    public E front() {
        return list.get(0);
    }

    /**
     * 获取尾部元素
     * @return E
     */
    public E rear() {
        return list.get(list.size() - 1);
    }

}
