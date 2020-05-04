package dynamic_array;

import jdk.nashorn.internal.ir.LiteralNode;

/**
 * USER:wbpjgs
 * TOTO:todo
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
        doubleLinkedListTest();
    }


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
