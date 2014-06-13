package trees;

import java.util.Iterator;
import java.util.Stack;

public class InOrderTraversalIterator implements Iterator{

    private Node root;
    private Stack st;
    private Node current;
    
	public InOrderTraversalIterator(Node root){
    	this.root = root;
    	st = new Stack();
    	
    	Node n = root;
    	while (n!= null){
    		st.push(n);
    		n = n.left;
    	}
        current = null;
	}
    
	@Override
	public boolean hasNext() {
        return current != null || !st.empty();
	}

	@Override
	public Object next() {
        current = (Node)st.pop();
        Node n = current;
		if (current != null) {
            current = current.right;
			processNode();
		}
        return n;
	}

	private void processNode(){
		while (true){
			if (current != null){
				st.push(current);
                current = current.left;
			} else {
				break;
			}
		}
	}
    
	@Override
	public void remove() {
        throw new UnsupportedOperationException();
	}
}
