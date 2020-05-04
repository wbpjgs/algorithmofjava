package dynamic_array;

/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: AbstractList
 * DATE: 2020/4/29
 * TIME: 23:21
 * VERSION:1.0.0
 * JDK 1.8
 */
public abstract class AbstractList<E> implements List<E> {
    protected Integer size = 0;

    /**
     * @return
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public void add(E element) {
        add(size, element);
    }

    //边界检查
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    //指定索引出添加元素检查
    protected void rangeCheckFor(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }

    }

    //抛出越界异常
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("index out of bounds exception:" + index);
    }


}
