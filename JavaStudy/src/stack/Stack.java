package stack;

import org.junit.Test;

import java.util.ArrayList;

public class Stack<E> {

    ArrayList<E> list;

    void push(E e) {
        list.add(e);
    }

    E pop() {
        if (list.isEmpty()) {
            return null;
        }

        return list.get(list.size() - 1);
    }

    void reverseInplace() {
        //TODO
    }

    @Test
    public void test1() throws Exception {
        Stack<Integer> s = new Stack<>();
        s.push(1);
    }
}

