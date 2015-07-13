/**
 * Created by vgupta on 5/27/15.
 */
import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class Solution {

    private static class Node {
        Node left, right;
        int data;
        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }

    private static Node insert(Node node, int data) {
        if (node==null){
            node = new Node(data);
        }
        else {
            if (data < node.data) {
                node.left = insert(node.left, data);
            }
            else {
                node.right = insert(node.right, data);
            }
        }
        return(node);
    }

    private static Node addRandomElement(Node node, int data, int index){
        if (node==null){
            node = new Node(data);
        }
        else {
            if (index <= 2) {
                node.left = addRandomElement(node.left, data,index);
            }
            else {
                node.right = addRandomElement(node.right, data,index);
            }

        }
        return(node);
    }

    /* Write your custom functions here */
    static int diameterOfTree(Node root) {

        if (root == null) return 0;
        int l = diameterOfTree(root.left);
        int r = diameterOfTree(root.right);

//        return Math.max(l+r
        return 0; //TODO
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        Node _root;
        int root_i=0, root_cnt = 0, root_num = 0;
        _root = null;
        int isBst = in.nextInt();
        root_cnt = in.nextInt();
        for(root_i = 0; root_i < root_cnt; root_i++){
            root_num = in.nextInt();
            if( isBst == 0 ){                         _root = addRandomElement(_root,root_num,root_i);
            } else {
                _root = insert(_root, root_num);
            }
        }

        bw.write(String.valueOf(diameterOfTree(_root)));
        bw.newLine();
        bw.close();
        return;
    }
}
