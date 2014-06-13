package trees;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class Node {

    Node left;
    Node right;
    Node parent;
    int data;
    
    Node(int data){
    	this.data = data;
    }
    
    
    @Override
	public String toString() {
		return data + " ";
	}


	Node getLeftMostNode(){
    	Node p = this;
    	while(p.left != null){
    		p = p.left;
    	}
		return p;
    }
    
    Node getSuccessor(){
    	if (right != null){
    		//look in right subtree
    		return right.getLeftMostNode();    		
    	} else {
    		//look in parent 
    		Node p = this;
    		while (true){
    			//handle null p case
    			if (p == null){
    				return null;
    			}
    			Node pp = p.parent;
    			
                if (pp != null && pp.left == p){
    				//p is pp's left child
    				return pp;
    			}    			
                p = pp;
    		}    		
    	}
    }
    
	Node getSmallestElement(final Node n){
		assert n != null;
		Node m = n;
		while (m.left != null){
			m = m.left;
		}
		return m;
	}
	
	Node getSuccessor(Node n){
		//if n has a right subtree, find the smallest element in it.
		if (n.right != null){
			return getSmallestElement(n.right);
		}
		
		//else find ancestor a of n who is a left child of its parent
		Node m = n;
		while (true){
			Node pp = null;
			if (m != null){
				pp = m.parent;
			}
			if (m == null || pp == null) {
				return null;
			}
			if(pp.left == m) {
				return pp;
			}
			m = pp;
		}
	}
    void printInOrder(){
    	Node startNode = getLeftMostNode();
        if (startNode == null)
        	return;
        
        System.out.print(startNode.data + " ");
        Node s = startNode.getSuccessor();
        while (s!= null){
        	System.out.print(s.data + " ");
        	s = s.getSuccessor();
        }               
    	System.out.println();
    }
    
	void addNode(Node n){
		if (n.data < data){
			//insert in left tree
			if (left != null){
				left.addNode(n);
				return;
			} else {
				//insert here
				left = n;
				n.parent = this;
				return;
			}
		} else if (n.data > data){
			if (right != null){
				right.addNode(n);
				return;
			} else {
				//insert here
				right = n;
				n.parent = this;
				return;
			}			
		}
		assert false;
	}
    
	int getDepthOfLeftSubtree(){
		if (left != null)
			return left.getDepthOfLeftSubtree() + 1;
		else
			return 0;
	}
	
	int getDepthOfRightSubtree(){
		if (right != null)
			return right.getDepthOfLeftSubtree() + 1;
		else
			return 0;
	}
	
	boolean isBalanced() {
		return getDepthOfLeftSubtree() == getDepthOfRightSubtree();		
	}		
    
	static boolean isSymmetric(Node n) {
		return isMirrorImage(n,n);
	}
	
	static boolean isMirrorImage(Node n1, Node n2)
	{
		if(n1==null && n2==null)
			return true;
		else if(n1==null || n2==null)
			return false;
		else if (n1.data != n2.data)		
			return false;
		else 
			return isMirrorImage(n1.left,n2.right) && isMirrorImage(n1.right,n2.left);
	}
    
    //TODO
    void printReverseInOrder(){ //do preorder and postorder too
    	
    }
    
    static int getDepth(Node root){
    	Stack<Node> stack = new Stack<Node>();
    	
    	Node current = root;
    	int depth = -1;
        int maxDepth = -1;
    	while(current != null || !stack.empty()){
    		if (current != null){
    			stack.add(current);
    			depth++; maxDepth = Math.max(maxDepth, depth);
    			current = current.left;
    		} else {
    			current = stack.pop();
    			assert current != null;
    			current = current.right;
                if (current == null) 
                	depth--;
    		}
    	}
        return maxDepth;
    }
    
    //Iteratively print all paths from root to leaf
    //DOESNT WORK as we can't tell if a node is already completely handled or not.
    //we probably need to keep state at a node if it just visited/completely visited
    static void printAllPathsToLeaves(Node root){
    	Stack<Node> stack = new Stack<Node>();
    	
    	Node current = root;
    	while(current != null || !stack.empty()){
    		if (current != null){
    			stack.add(current);
    			current = current.left;
    		} else {
    			current = stack.pop();
    			assert current != null;
                
    			boolean isLeaf = current.left == null && current.right == null;
    			
                if (isLeaf){
                	//print the contents of the stack
                    System.out.println(stack);
                    
                	//pop all ancestors that are right children of its parent
                    Node p;
                    Node parent;
                    
                    do {
                    	p = stack.pop();
                        if (!stack.empty())
                        	parent = stack.peek();
                        else
                        	parent = null;
                    } while (p != null && parent != null && parent.right == p);
                    
                    if (parent != null)
                    	current = parent.right;
                    else
                    	current = null;
                } else {
                	//go down into the right subtree
                	current = current.right;
                }
    		}
    	}
    }
    
    static void printAllPathsToLeaves(Node root, Vector<Node> path){
        if (root == null) return;
        if (root.left == null && root.right == null) {
        	for(Node n: path){
        		System.out.print(n + "->");
        	}
    		System.out.println(root);
            return;
        }
    	
        path.add(root);
        int len = path.size();
        
        printAllPathsToLeaves(root.left, path);
        int newLen = path.size();
        for (int j = newLen - 1; j >= len; j--)
        	path.remove(j);
        assert len == path.size();
        
        printAllPathsToLeaves(root.right, path);
        newLen = path.size();
        for (int j = newLen - 1; j >= len; j--)
        	path.remove(j);
        assert len == path.size();
    }
    
    static void inOrderTraversalIterative(Node root){
        //see http://www.leetcode.com/2010/04/binary-search-tree-in-order-traversal.html
    }
    
    static Iterator inOrderIterator(Node root){
    	return new InOrderTraversalIterator(root);
    }
    
    //TODO
    static void preOrderTraversalIterative(Node root){
        
    }
    
    //TODO
    static void levelOrderTraversalIterative(Node root){
    	
    }
    
    static boolean isValidBST(Node root){
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    static boolean isValidBST(Node root, int min, int max){
        if (root == null) return true;
    	if (root.data <= min || root.data > max)
    		return false;
    	
        return isValidBST(root.left, min, Math.min(max, root.data)) &&
               isValidBST(root.right, Math.max(min, root.data), max);
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(10);
		root.printInOrder();
        System.out.println("depth = " + getDepth(root));
        
		Node left = new Node(5);
		Node right = new Node(20);
		root.left = left;
		left.parent = root;
		root.right = right;
		right.parent = root;
        
		root.printInOrder();
        System.out.println("depth = " + getDepth(root));
        System.out.println("All paths to leaves = ");
        printAllPathsToLeaves(root, new Vector<Node>());
        
		Node leftleft = new Node(4);
        leftleft.parent = left;
        left.left = leftleft;
        
		root.printInOrder();
        System.out.println("depth = " + getDepth(root));
        System.out.println("All paths to leaves = ");
        printAllPathsToLeaves(root, new Vector<Node>());
        
		root = new Node(10);
        boolean isSymmetric = Node.isSymmetric(root);
        System.out.println("root is symmetric: " + isSymmetric);
		left = new Node(5);
		right = new Node(5);
		root.left = left;
		left.parent = root;
		root.right = right;
		right.parent = root;
        isSymmetric = Node.isSymmetric(root);
        System.out.println("root is symmetric: " + isSymmetric);
        
		Node rr = new Node(40);
        rr.parent = right;
        right.right = rr;
        
		Node ll2 = new Node(40);
        ll2.parent = left;
        left.left = ll2;
		root.printInOrder();
        System.out.println("depth = " + getDepth(root));
        isSymmetric = Node.isSymmetric(root);
        System.out.println("root is symmetric: " + isSymmetric);
        
		Node lr = new Node(40);
        lr.parent = left;
        left.right = lr;
		root.printInOrder();
        System.out.println("depth = " + getDepth(root));
        isSymmetric = Node.isSymmetric(root);
        System.out.println("root is symmetric: " + isSymmetric);
        
        System.out.println("All paths to leaves = ");
        printAllPathsToLeaves(root, new Vector<Node>());
	}

}
