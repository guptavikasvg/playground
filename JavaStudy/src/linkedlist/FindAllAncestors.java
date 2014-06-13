package linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import trees.Node;

//Question 1: There is a binary tree of size N. All nodes are numbered between 
//1-N(inclusive). There is a N*N integer matrix Arr[N][N], all elements are 
//initialized to zero. So for all the nodes A and B, put Arr[A][B] = 1 if 
//A is an ancestor of B (NOT just the immediate ancestor).
public class FindAllAncestors {
	static void findAncestorsDFS(Node root, int[][] ancestors, int N) {
		//create a stack
		Stack<Node> st = new Stack<Node>();
		st.add(root);
		
		//push children one by one
		
		//when all children are done, pop parent and update its children.
	}
	
	static void findAncestorsRecursive(Node root, int[][] ancestors, int N) {
		if (root == null) return;
		
        List<Node> children = new ArrayList<Node>();
        children.add(root.left);
        children.add(root.right);
        
        for (Node child: children){
    		if (child != null){
    			//find children for child
    			findAncestorsRecursive(child, ancestors, N);
    			
    			//update children for root
    			updateChildren(root, child, ancestors, N);
    		}
        }
	}

	static void updateChildren(Node root, Node left, int[][] ancestors, int N) {
		assert root != null;
		assert left != null;
		
		//get id of root
        int parent = root.data;
        int immediateChild = left.data;
        
        //go over all children of immediateChild and add to parent's list of children
        for (int i = 0; i < N; i++){
        	if (ancestors[immediateChild][i] == 1) {
        		ancestors[parent][i] = 1;
        	}
        }
		ancestors[parent][immediateChild] = 1;
	}
    
	static void test1() {
		Node root = new Node(2);
		Node n1 = new Node(1);
		Node n2 = new Node(0);
		Node n3 = new Node(4);
		Node n4 = new Node(3);
        
		root.addNode(n1);
		root.addNode(n2);
		root.addNode(n3);
		root.addNode(n4);
        
        int[][] ancestors = new int[5][5];
        
        findAncestorsRecursive(root, ancestors, 5);
        
        dump(ancestors, 5);
	}

	private static void dump(int[][] ancestors, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(ancestors[i][j]);
    		}
            System.out.println();
		}
        System.out.println();
	}
    
	public static void main(String[] args) {
		test1();
	}
}