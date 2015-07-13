package linkedlist;

import org.junit.Test;

/**
 * Created by vgupta on 4/26/15.
 */
//head->a->b->null
//head->b->a->null
    //Head of the linked list is pointed by a dummy node head
public class LinkedList2 {

    class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node() {
            next = null;
        }

        /**
         * Reverse the list and sets the new head
         */
        void reverse() {
            Node head = this.next;

            Node p = head;

            if (p == null) {
                return;
            }
            Node q = head.next;

            if (q == null) {
                return;
            }

            p.next = null;

            while (q != null) {
                Node qnext = q.next;
                q.next = p;
                p = q;
                q = qnext;
            }

            //set the head
            this.next = p;

        }

        public void add(int v) {
            Node p = this.next;

            Node q = null;
            while (p != null) {
                q = p;
                p = p.next;
            }

            if (q != null) {
                //found a non-null last element
                q.next = new Node(v);
            } else {
                //no elements in the LL.
                this.next = new Node(v);
            }
        }

        public void print() {
            System.out.print("head->");
            Node p = this.next;

            while (p != null) {
                System.out.print(p.value + "->");
                p = p.next;
            }
            System.out.println("null");
        }
    }

    @Test
    public void test1() throws Exception {
        Node head = new Node();
        head.add(1); head.add(2); head.add(3);

        head.print();
        head.reverse();
        head.print();
    }

    @Test
    public void test2() throws Exception {
        Node head = new Node();
        head.print();
        head.reverse();
        head.print();
    }

    @Test
    public void test3() throws Exception {
        Node head = new Node();
        head.add(100);
        head.print();
        head.reverse();
        head.print();
    }
}
