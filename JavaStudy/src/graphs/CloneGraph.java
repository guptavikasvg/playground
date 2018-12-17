package graphs;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    static Node clone(Node root){
    	Map<Node, Node> partner = new HashMap();
    
    	return clone(root, partner);
    }
    static Node clone(Node root, Map partners){
        
        if (root == null) return null;
        
        //clone root if not already cloned
        Node root2 = (Node) partners.get(root);
        
        if (root2 == null){
        	root2 = new Node(root.getData());
            partners.put(root, root2);
        } else {
        	return root2;
        }
        
        //now handle all children of root
        for (Node child: root.getChildren()){
        	root2.addChild(clone(child, partners));
        }
        
    	return root2;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(100);
		Node n1 = new Node(200);
		root.addChild(n1);
	
		Node root2 = clone(root);
	}
}