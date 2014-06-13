package interview.linkedin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sample input:
 *
 *          1
 *         / \
 *        3   5
 *       / \   \
 *      2   4   7
 *     /   / \
 *    9   6   8
 *
 * Expected output:
 *    1
 *    3 5
 *    2 4 7
 *    9 6 8
 */
public class TreePrinter {
 
  static class Node {
    int value;
    Node left;
    Node right;
    public Node(int value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
 
  //CAUTION: wrong implementation. Doesn't print newlines between different levels. To achieve that
  //either use 2 stacks or insert a sentinel while popping the last element from a level
  //See correct solution that uses SENTINEL node in Node.java
  public void printTree(Node root) {
       if (root  == null)
           return;
       
       Queue q = new LinkedList<Node>();
       q.add(root);
       
       while(!q.isEmpty()) {
           Node n = (Node) q.remove();
           System.out.print(n.value);
           q.add(n.left);
           q.add(n.right);
       }       
  }
  
  public static void main(String[] args) {
    
  }
}
