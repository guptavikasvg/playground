package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindCompleteBinaryTree {

	static class Node {
	    Node left;
	    Node right;
	}
    
	/**
	  * lets say depth of root is 0
	  */
	static int getDepth(Node root) {
		Queue q = new LinkedList();
		q.add(root);
	    return getCompleteDepth(0, q);
	}
	
	static int getDepthIterative(Node root) {
		Queue q = new LinkedList();
		q.add(root);
	    return getCompleteDepthIterative(0, q);
	}

	/**
	  * Is the tree at depth complete
	  */
	static int getCompleteDepth(int depth, Queue q ) {
		Queue newQ = new LinkedList();
	    for (Object o : q){
	    	if (o instanceof Node){
		    	Node left = ((Node)o).left;
		    	Node right = ((Node)o).right;
		    	
		    	if (left != null) {
					newQ.add(left);
				}
		    	if (right != null) {
					newQ.add(right);
				}
	    	}
	    }
	    
	    if (newQ.size() < Math.pow(2, depth+1)) {
			return depth;
		}
	    
	    return getCompleteDepth(depth+1, newQ);
	}
	
	static int getCompleteDepthIterative(int depth, Queue q ) {
		
		while(true){
			Queue newQ = new LinkedList();
		    for (Object o : q){
		    	if (o instanceof Node){
			    	Node left = ((Node)o).left;
			    	Node right = ((Node)o).right;
			    	if (left != null) newQ.add(left);
			    	if (right != null) newQ.add(right);
		    	}
		    }
		    
		    if (newQ.size() < Math.pow(2, depth+1)) {
				return depth;
			}
	
		    depth++;
		    q = newQ;
		    newQ = null;
		}
	}
}
	/**
	 * @param args
	 */
//	public static void main(String[] args) {

//		//make tree
//		int depth = new FindCompleteBinaryTree().isComplete();
//		System.out.println("depth = " + depth);
//		
//		// level 2 tree
//		FindCompleteBinaryTree root = new FindCompleteBinaryTree();
//		root.left = new FindCompleteBinaryTree();
//		depth = root.getCompleteDepth();
//		System.out.println("depth = " + depth);
//		
//		// level 2 tree
//		FindCompleteBinaryTree root2 = new FindCompleteBinaryTree();
//		root2.left = new FindCompleteBinaryTree();
//		root2.right = new FindCompleteBinaryTree();
//		depth = root2.isComplete();
//		System.out.println("depth = " + depth);
//	}
	
