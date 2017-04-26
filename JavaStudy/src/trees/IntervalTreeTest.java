package trees;

import com.tc.util.Assert;
import org.junit.jupiter.api.Test;

/**
 * Interval tree
 *
 * Created by root1 on 4/23/17.
 */
public class IntervalTreeTest {
    @Test
    public void test1() {
        Tree2 tree = new Tree2();
        tree.add(10, 20);
        tree.add(5, 7);
        tree.add(11, 30);

//        System.out.println(tree.root.search(new Interval(5,6)));
        Assert.assertEquals(new Interval(5, 7), tree.root.search(new Interval(5,6)));
        Assert.assertEquals(new Interval(10, 20), tree.root.search(new Interval(10, 20)));
        Assert.assertEquals(null, tree.root.search(new Interval(1,2)));
    }
}

class Tree2 {
    Node2 root;

    void add(int startInterval, int endInterval) {
        if (root == null) {
            root = new Node2(new Interval(startInterval, endInterval));
        } else {
            root.add(startInterval, endInterval);
        }
    }
}

class Node2 {
    Node2 left;
    Node2 right;
    Interval interval;
    int min;
    int max;

    public Node2(int left, int right) {
        this(new Interval(left, right));
    }

    public Node2(Interval interval) {
        this.interval = interval;
        min = interval.start;
        max = interval.end;
        left = right = null;
    }

    // add in left/right subtree
    public void add(int startInterval, int endInterval) {
        if (startInterval <= this.interval.start) {
            if (left != null) {
                left.add(startInterval, endInterval);
            } else {
                //add as left child
                left = new Node2(startInterval, endInterval);
            }

            //node added to left subtree
        } else { //add to the right subtree
            if (right != null) {
                right.add(startInterval, endInterval);
            } else {
                //add a new child in the right subtree
                right = new Node2(startInterval, endInterval);
            }
        }
        min = Math.min(min, startInterval);
        max = Math.max(max, endInterval);
    }

    public Interval search(Interval interval) {
        //TODO check for null

        //check for match in the current node
        if (interval.intersects(this.interval)) {
            return this.interval;
        }

        //check left tree
        if (left != null && interval.start <= left.max) {
            return this.left.search(interval);
        }

        //check right tree
        if (right != null) {
            return this.right.search(interval);
        }

        return null;
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean intersects(Interval second) {
        assert second != null;
        return !(second.end < start || second.start > end);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Interval{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;

        Interval interval = (Interval) o;

        if (start != interval.start) return false;
        return end == interval.end;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}