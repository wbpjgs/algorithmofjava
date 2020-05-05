package dynamic_array;

import javafx.scene.media.VideoTrack;
import jdk.nashorn.internal.ir.LiteralNode;

import javax.sound.midi.Soundbank;

/**
 * USER:wbpjgs
 * TOTO:测试类
 * CLASSNAME: Main
 * DATE: 2020/4/28
 * TIME: 23:58
 * VERSION:1.0.0
 * JDK 1.8
 */
public class Main {
    public static void main(String[] args) {
//        LinkedListTest();
//        growOrtrimCapacityTest();
//        doubleLinkedListTest();
//        singleCircleLinkedListTest();
//        doubleCircleLinkedListTest();
//        josephusTest();
//        stackTest();
//        queueTest();
//        deQeueTest();
//        circleQueueTest();
        circleDequeTest();
    }

    private static void circleDequeTest() {
        CircleDeque<Integer> circleDeque = new CircleDeque<>();
        for (int i = 0; i < 10; i++) {
             circleDeque.enQueueFront(i+1);
             circleDeque.enQueuerear(i+100);

        }
        System.out.println(circleDeque);
        for (int i = 0; i < 3; i++) {
             circleDeque.deQueueFront();
             circleDeque.deQueueRear();
        }
        circleDeque.enQueueFront(200);
        circleDeque.enQueueFront(201);
        circleDeque.enQueuerear(2000);
        circleDeque.enQueuerear(2001);
        System.out.println(circleDeque);
        System.out.println(circleDeque.deQueueRear());
    }

    //循环队列测试
    private static void circleQueueTest() {
        CircleQueue<Integer> circleQueue = new CircleQueue<>();
        for (int i = 1; i <= 9 ; i++) {
             circleQueue.enQueue(i);
        }
        System.out.println("circleQueue elements:"+circleQueue);
        System.out.println("出队1:"+circleQueue.deQueue());
        System.out.println("出队2:"+circleQueue.deQueue());
        circleQueue.enQueue(15);
        circleQueue.enQueue(16);
        circleQueue.enQueue(17);
        System.out.println(circleQueue);
        System.out.println("出队3:"+circleQueue.deQueue());
        System.out.println("出队4:"+circleQueue.deQueue());
        for (int i = 100; i < 110; i++) {
             circleQueue.enQueue(i);
        }
        System.out.println(circleQueue);
    }

    //双向队列测试
    private static void deQeueTest() {
        Deque<Integer> deque = new Deque<>();
        deque.enQueueFront(11);
        deque.enQueueFront(22);
        deque.enQueuerear(33);
        deque.enQueuerear(44);//[22 11 33 44] 尾
        while (!deque.isEmpty()) {
            System.out.println(deque.deQueueFront());
//            System.out.println(deque.deQueueRear());
        }
    }

    //单向队列测试
    private static void queueTest() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }

    //栈测试
    private static void stackTest() {
        Stack<String> stack = new Stack<>();
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    //约瑟夫问题测试
    private static void josephusTest() {
        DoubleCircleLinkedList<Integer> list = new DoubleCircleLinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        list.reset();

        while (list.size != 0) {
            list.next();
            list.next();
            System.out.println(list.remove());
            System.out.println(list);
        }
        System.out.println(list);

    }

    //双向循环列表测试
    private static void doubleCircleLinkedListTest() {
        List<Integer> list = new DoubleCircleLinkedList<>();
        list.add(24);
        list.add(23);
        list.add(0, 6);
        list.add(30);
        list.remove(0);
        System.out.println(list); //[24,23,30]
    }


    //单向循环链表测试
    private static void singleCircleLinkedListTest() {
        List<Integer> list = new SingleCircleLinkedList<>();
        list.add(24);
        list.add(23);
        list.add(0, 6);
        list.add(30);
        list.remove(0);
        System.out.println(list); //[6,24,23,30]
    }

    //双向链表测试
    private static void doubleLinkedListTest() {
        List<Integer> list = new DoubleLinkedList<>();
        //add elements
        list.add(10);
        list.add(15);
        list.add(18);
        list.add(12);
        list.add(1, 33);
        System.out.println(list); //[10,33,15,18,12]
        //remove elements
        list.remove(0);//[33,15,18,12]
        list.remove(3);//[33,15,18]
        list.remove(1);//[33,15,18]
        System.out.println(list);// [33,18]
    }

    private static void LinkedListTest() {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.remove(0);
        list.add(10);
        list.add(12);
        list.add(15);
        list.set(1, 99);
        list.add(30);
        list.clear();
        System.out.println(list);
    }

    //list 扩展减容测试
    private static void growOrtrimCapacityTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        for (int i = 0; i < 50; i++) {
            list.remove(0);
        }
    }
}
