import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/*
public class FindLCA {
    class Node {

    void fillSet(Node node, Set node1ToRootNodes) {
       //TODO check for nulls etc.
       Node p = node;
       while(p != null){
           node1ToRootNodes.put(p); 
           p = p.parent;
        }    
    
    }
    
    Node findLCA(Node root, Node node1, Node n2){
        //TODO check for nulls etc.
        
        Set node1ToRootNodes = new HashSet();
        
        fillSet(root, node1, node1ToRootNodes);
        
        Node p = n2;
        while(p != null){
            if (node1ToRootNodes.contains(p)) {
                // found the LCA
                return p;
            }
            p = p.parent;
        }
        
        return null;
    
    }
    
   Node findLCA(Node root, Node n1, Node n2){
        //TODO check for nulls etc.
        Vector pathn1 = findPath(root, n1); //e.g. n1, 10, 8, 5, 3, 1
        Vector pathn2 = findPath(root, n2); //e.g. n2, 15, 12,   3, 1 (3 is lca)
 
        //now iterate over pathn2 and find the last node that is also in pathn2
        int minPathLen = Math.min(pathn1.size(), pathn2.size());
        
        int len = minPathLen;
        int m1 = pathn1.length() - 1;
        int m2 = pathn2.length() - 1;        
        Node ancestor = null;
        while (len > 0) {
            Node nn1 = pathn1.at(m1);
            Node nn2 = pathn1.at(m2);            
            if (nn1 == nn2) {
                ancestor = nn1;               
            } else {
                break;
            }
            m1--;
            m2--;
            len--;        
        }
        
        return ancestor;
    }
    
    static final Vector nullVector = new Vector(0);
    Vector findPath(Node root, Node n) {
        //base condition
        if (root == nil || n == nil) {
            return nullVector;
            
        if (root == n) {
            Vector retval = new Vector();
            retval.push_back(n);
            return retval;
        }
        for (int i =0; i < children.length; i++) {
            Vector subpath = findPath(children[i], n);
            if (subpath != nil && !subpath.isEmpty()) {
                subpath.push_back(root);
                return subpath;
            }
        }
    
    }
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
*/