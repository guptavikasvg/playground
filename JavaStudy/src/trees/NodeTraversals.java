package trees;

import java.util.Stack;

public class NodeTraversals {

    static void inOrderTraversalIterative(Node root){
        //see http://www.leetcode.com/2010/04/binary-search-tree-in-order-traversal.html
        //see http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
        
    	Stack stack = new Stack();
    	Node current = root;
    	while (current != null || !stack.isEmpty()){
    		if (current != null){
        		stack.push(current);
        		current = current.left;
    		} else {
    			if (!stack.isEmpty()){
        			Node current2 = (Node)stack.pop();
                    System.out.print(current2);
                    current = current2.right;
    			}
    		}
    	}
        System.out.println();
    }
    
    //http://www.brilliantsheep.com/iterative-binary-tree-traversal-in-java/
    static void inOrderTraversalIterative2(Node root){
        if( root == null ) return;
         
        Stack<Node> stack = new Stack<Node>( );
        stack.push( root );
         
        while( ! stack.isEmpty( ) ) {
            Node current = stack.pop( );
            if( current.right != null ) stack.push( current.right );
            if( current.left != null ) stack.push( current.left );
            System.out.print( current.data + " " );
        }
    }
    
    static void preOrderTraversalIterative(Node root){
    	Stack stack = new Stack();
    	Node current = root;
        
    	while(current != null || !stack.isEmpty()) {
    		if(current != null){
    			System.out.print(current);
                stack.push(current);
                current = current.left;
    		} else {
    			//pop from stack and go into right subtree
    			if (!stack.isEmpty()){
        			Node current2 = (Node)stack.pop();
                    current = current2.right;
    			}
    		}
    	}
        System.out.println();
    }
    
    //http://www.brilliantsheep.com/iterative-binary-tree-traversal-in-java/
    static void postOrderTraversalIterative(Node root){
	    if( root == null ) return;
    	 
	    Stack<Node> stack = new Stack<Node>( );
	    Node current = root;
    	 
	    while( true ) {
    	 
	        if( current != null ) {
	            if( current.right != null ) stack.push( current.right );
	            stack.push( current );
	            current = current.left;
	            continue;
	        }
    	 
	        if( stack.isEmpty( ) ) break;
	        current = stack.pop( );
    	 
	        if( current.right != null && ! stack.isEmpty( ) && current.right == stack.peek( ) ) {
	            stack.pop( );
	            stack.push( current );
	            current = current.right;
	        } else {
	            System.out.print( current.data + " " );
	            current = null;
	        }
    	}
        System.out.println();
    }
    
    //my try of above
    static void postOrderTraversalIterative2(Node root){
    	Stack stack = new Stack();
    	
    	Node current = root;
    	
    	while(current != null || !stack.isEmpty()){
    		if (current != null){
    			if (current.right != null) 
    				stack.push(current.right);
    			stack.push(current);
    			current = current.left;
    			continue;
    		}
    		
    		// current is null. So, lets look in the stack.
    		if (stack.isEmpty()){
    			break;
    		}
    		
    		Node node = (Node)stack.pop();
    		if (stack.isEmpty()){
                System.out.print(node);
    			break;
    		}
    		Node node2 = (Node)stack.peek();
    		
    		if (node2 == node.right){
        		stack.pop();
    			//still need to handle node's right subtree i.e. node2 subtree
    			stack.push(node);
                current = node2;
    		} else {
                System.out.print(node);
    		}
    	}
        System.out.println();
    }
    
    //http://www.careercup.com/question?id=14261680
    static void postOrderTraversalIterative3(Node root){
    	Stack stack = new Stack();
    	
    	if (root != null) return;
	  
    	Stack s = new Stack();
    	Stack output = new Stack();
    	s.push(root);
    	while (!s.isEmpty()) {
    		Node curr = (Node) s.peek();
    		output.push(curr);
    		s.pop();
    		if (curr.left == null)
    			s.push(curr.left);
    		if (curr.right == null)
    			s.push(curr.right);
    	}
	  
    	while (!output.isEmpty()) {
    		System.out.print(output.pop());
    	}
		System.out.println();
    }
    
    static void testInOrderTraversalIterative(){
		Node root = new Node(10);
        inOrderTraversalIterative(root);
        
		Node left = new Node(5);
		Node right = new Node(20);
        
		root.addNode(left);
        inOrderTraversalIterative(root);
		root.addNode(right);
        inOrderTraversalIterative(root);
        
		Node n4 = new Node(12);
        root.addNode(n4);
        inOrderTraversalIterative(root);
        
		Node n5 = new Node(11);
        root.addNode(n5);
        inOrderTraversalIterative(root);
    }
    
    static void testPreOrderTraversalIterative(){
		Node root = new Node(10);
        preOrderTraversalIterative(root);
        
		Node left = new Node(5);
		Node right = new Node(20);
        
		root.addNode(left);
        preOrderTraversalIterative(root);
		root.addNode(right);
        preOrderTraversalIterative(root);
        
		Node n4 = new Node(12);
        root.addNode(n4);
        preOrderTraversalIterative(root);
        
		Node n5 = new Node(11);
        root.addNode(n5);
        preOrderTraversalIterative(root);
        
		Node n6 = new Node(30);
        root.addNode(n6);
        preOrderTraversalIterative(root);
    }
    
    static void testPostOrderTraversalIterative(){
		Node root = new Node(10);
        postOrderTraversalIterative(root);
        postOrderTraversalIterative2(root);
        postOrderTraversalIterative3(root);
        
		Node left = new Node(5);
		Node right = new Node(20);
        
		root.addNode(left);
        postOrderTraversalIterative(root);
        postOrderTraversalIterative2(root);
        postOrderTraversalIterative3(root);
		root.addNode(right);
        postOrderTraversalIterative(root);
        postOrderTraversalIterative2(root);
        postOrderTraversalIterative3(root);
        
		Node n4 = new Node(12);
        root.addNode(n4);
        postOrderTraversalIterative(root);
        postOrderTraversalIterative2(root);
        postOrderTraversalIterative3(root);
        
		Node n5 = new Node(11);
        root.addNode(n5);
        postOrderTraversalIterative(root);
        postOrderTraversalIterative2(root);
        postOrderTraversalIterative3(root);
        
		Node n6 = new Node(30);
        root.addNode(n6);
        postOrderTraversalIterative(root);
        postOrderTraversalIterative2(root);
        postOrderTraversalIterative3(root);
    }
    
    
	public static void main(String[] args) {
		//testInOrderTraversalIterative();
//		testPreOrderTraversalIterative();
		testPostOrderTraversalIterative();
	}

}
