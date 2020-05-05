package dynamic_array;

/**
 * USER:wbpjgs
 * TOTO:自定义的栈
 * CLASSNAME: Stack
 * DATE: 2020/5/5
 * TIME: 10:38
 * VERSION:1.0.0
 * JDK 1.8
 */
public class Stack<E> {
    private List<E> list = new ArrayList<>();

    /**
     * 返回栈大小
     *
     * @return int
     */
    public int size() {
        return list.size();
    }

    /**
     * 判断栈中元素是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 清空栈中的元素
     */
    public void clear() {
        list.clear();
    }

    /**
     * 向栈中压入元素
     *
     * @param element
     */
    public void push(E element) {
        list.add(element);
    }

    /**
     * 弹出栈顶元素
     *
     * @return E
     */
    public E pop() {
        return list.remove(list.size() - 1);
    }

    /**
     * 取得栈顶元素
     *
     * @return E
     */
    public E top() {
        return list.get(list.size() - 1);
    }

}
