package leetcode.栈;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.Stack;

/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: _232_用栈实现队列
 * DATE: 2020/5/5
 * TIME: 11:21
 * VERSION:1.0.0
 * JDK 1.8
 * url:https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class _232_用栈实现队列 {
    //test
    public static void main(String[] args) {
        _232_用栈实现队列 queue = new _232_用栈实现队列();
        for (int i = 0; i < 5; i++) {
            queue.push(i);
        }
        while (!queue.empty()) {
            System.out.println(queue.pop());
        }
    }

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public _232_用栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.empty() && outStack.isEmpty();
    }
    //检查出队列的栈是否为空
    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
