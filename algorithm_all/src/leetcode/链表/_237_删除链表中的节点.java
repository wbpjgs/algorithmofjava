package leetcode.链表;

/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: _237_删除链表中的节点
 * DATE: 2020/5/3
 * TIME: 18:49
 * VERSION:1.0.0
 * JDK 1.8
 *
 * url:https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public static void main(String[] args) {

    }
}
