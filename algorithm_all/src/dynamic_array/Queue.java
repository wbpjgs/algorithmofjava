package dynamic_array;

import jdk.nashorn.internal.ir.LiteralNode;

/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: Queue
 * DATE: 2020/5/5
 * TIME: 11:34
 * VERSION:1.0.0
 * JDK 1.8
 */
public class Queue<E> {
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
     * 入队
     *
     * @param element
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 出队
     *
     * @return E
     */
    public E deQueue() {
        return list.remove(0);
    }

    /**
     * 清空队列
     */
    public void clear() {
        list.clear();
    }

    /**
     * 获取队头元素
     *
     * @return E
     */
    public E peek() {
        return list.get(0);
    }
}
