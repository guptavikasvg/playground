package trees;

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The BinaryNode class is defined as follows: */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class BinaryNode {
    int data;
    BinaryNode left;
    BinaryNode right;
}

public class BinarySearchTreeDetector {
    static boolean checkBST(BinaryNode root) {
        return checkBST(root, -1, 10001);
    }

    static boolean checkBST(BinaryNode root, int lo, int hi) {
        if (root != null) {
            if (root.data <= lo || root.data >= hi) {
                return false;
            }
        }

        boolean isBST = true;
        if (root.left != null) {
            isBST = checkBST(root.left, lo, Math.min(hi, root.data));
        }

        if (!isBST) return isBST;

        if (root.right != null) {
            isBST = checkBST(root.right, Math.max(lo, root.data), hi);
        }

        return isBST;
    }
}

class BinarySearchTreeDetectorTest {
    @Test
    public void test1() {
        assertEquals(true, BinarySearchTreeDetector.checkBST(null));
    }
}