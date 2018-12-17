package linkedlist;

/**
 * Created by root1 on 5/16/17.
 */
public class ReverseLinkedListTest {
    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    static <T> Node<T> reverse(Node<T> root) {
        if (root == null) {
            return null;
        }

        Node<T> retval = null;
        Node<T> p = root;

        while (p != null) {
            Node<T> q = p.next; //save p.next
            p.next = retval;
            retval = p;
            p = q; //move to next node
        }

        return retval;
    }

    static <T> void dump(Node<T> root) {
        while (root != null) {
            System.out.print(root.data + "->");
            root = root.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        //1
        Node<Integer> root = null;
        dump(root);
        dump(reverse(root));

        //2
        root = new Node<>(0);
        dump(root);
        dump(reverse(root));

        //3
        root = new Node<>(0);
        Node<Integer> node2 = new Node<>(1);
        Node<Integer> node3 = new Node<>(2);
        root.next = node2;
        node2.next = node3;
        dump(root);
        dump(reverse(root));
    }
}
