package graphs;

import java.util.ArrayList;
import java.util.List;

class Node {
	public Node(int i) {
        data = i;
        children = new ArrayList<Node>();
	}
	
	void addChild(Node n){
		children.add(n);
	}
	int data;
	List<Node> children;
    
	void dump(Node root){
		
	}
}