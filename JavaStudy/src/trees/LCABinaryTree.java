package trees;

public class LCABinaryTree {

    static Node LCA(Node root, Node p, Node q) {
        if (root == null)
            return null;
            
        if (root == p || root == q)
            return root;
            
        Node n1 = LCA(root.left, p, q);
        Node n2 = LCA(root.right, p, q);
        
        if (n1 != null && n2 != null) return root;
        return n1 != null ? n1 : n2;
    }
    
    static void testLCA1(){
		Node root = new Node(100);
		Node n1 = new Node(50);
		Node n2 = new Node(200);
		Node n3 = new Node(125);
		root.addNode(n1);
		root.addNode(n2);
		root.addNode(n3);
        
		System.out.println(LCA(root, n1, n3));
		System.out.println(LCA(root, n2, n3));
    }
    
    public static void main(String[] args) {
		testLCA1();
	}
}
