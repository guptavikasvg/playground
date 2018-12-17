package graphs;

import java.util.*;

public class IterativeDFS {

	static void dumpStack(Stack<Node> s){
	
        for (Node object : s) {
    		System.out.print(object.getData() + "->");
		}
        System.out.println();
	}

	// Do not use this. This is very complicated. Use doDFS2() below.
    static void doDFS(Node root) {
    	Stack s = new Stack();
    	Map handled = new HashMap();
    	
    	s.push(root);
    	
    	while(!s.isEmpty()){
    		Node n = (Node) s.peek();
            
    		//if all children are handled, then continue
            if (handled.containsKey(n)){
            	s.pop();
            } else {
            	//check if we have reached leaf
            	if (n.getChildren() == null || n.getChildren().isEmpty()){
            		//print path contained in stack
                    dumpStack(s);
            		
            		//mark leaf as handled
                	handled.put(n, true);
            	} else {
            		//else handle remaining nodes
            		boolean flag = false;  
                    for (Node child: n.getChildren()){
                    	if (!handled.containsKey(child)){
                    		s.push(child);
                    		flag = true; 
                            break;
                    	}
                    }
                    
                    //if all leaves are handled, then mark n as handled
                    if (!flag){
                    	handled.put(n, true);
                    }
            	}
            }
    	}
    }

    static List<Node> doDFS2(Node root) {
		Stack<Node> s = new Stack();
		s.add(root);

		// tracks if a node is visited or not
		Map<Node, Boolean> visited = new HashMap<>();

		List<Node> retval = new ArrayList<>();
		while (!s.isEmpty()) {
			dumpStack(s);
			Node n = s.pop();

			retval.add(n);
			visited.put(n, true);
			for (Node child : n.getChildren()) {
				if (visited.get(child) == null) {
					s.push(child);
				}
			}
		}

		return retval;
	}
    
    public static void main(String[] args) {
		Node root = new Node(100);
		Node n1 = new Node(200);
		
		Node n2 = new Node(300);
		Node n3 = new Node(400);
		Node n4 = new Node(500);
		Node n5 = new Node(600);
        
		n2.addChild(n3);
		n2.addChild(n4);
		n2.addChild(n5);
        
		root.addChild(n1);
		root.addChild(n2);

		n5.addChild(new Node(700));
        
		//doDFS(root);

		System.out.println(doDFS2(root));
	}
}