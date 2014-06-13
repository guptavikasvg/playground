package trees;

public class MedianBST {

    static int getMedian(Node root){
        if (root == null) return 0;
        
    	InOrderTraversalIterator slowItr = new InOrderTraversalIterator(root);
    	InOrderTraversalIterator fastItr = new InOrderTraversalIterator(root);
    	
        int count = 0;
        
    	Node slow = null;
    	while(fastItr.hasNext()){
            fastItr.next(); count++;
    		if (fastItr.hasNext()){
                fastItr.next(); count++;
                slow = (Node) slowItr.next();
    		} 
    	}
    	
        Node slow2 = (Node) slowItr.next();
        if ((count & 1) == 1){
        	//odd
            return slow2.data;
        } else {
        	//even
            return (slow.data + slow2.data)/2;
        }
    }
    
	public static void main(String[] args) {
        Node root = null;
//        Node.printInOrder(root);
		System.out.println(getMedian(root));
		root = new Node(100);
        Node.printInOrder(root);
		System.out.println(getMedian(root));
        
		Node n1 = new Node(50);
		root.addNode(n1);
        Node.printInOrder(root);
		System.out.println(getMedian(root));
        
		Node n2 = new Node(200);
		root.addNode(n2);
		Node n3 = new Node(125);
		root.addNode(n3);
		Node n4 = new Node(300);
		root.addNode(n4);
		Node n5 = new Node(25);
		root.addNode(n5);
        
        Node.printInOrder(root);
		System.out.println(getMedian(root));
        
		Node n6 = new Node(75);
		root.addNode(n6);
        
        Node.printInOrder(root);
		System.out.println(getMedian(root));
        
	}
}
