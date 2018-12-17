//package trees;
//
//import static org.junit.Assert.*;
//
//import java.util.Iterator;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//
//public class NodeTest {
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void testGetSmallestElement() {
//		Node root = new Node(100);
//		Node n1 = new Node(50);
//		Node n2 = new Node(200);
//		Node n3 = new Node(125);
//		root.addNode(n1);
//		root.addNode(n2);
//		root.addNode(n3);
//
//		assertEquals(100, root.getSuccessor(n1).data);
//		assertEquals(null, root.getSuccessor(n2));
//		assertEquals(125, root.getSuccessor(root).data);
//		assertEquals(200, root.getSuccessor(n3).data);
//	}
//
//	@Test
//	public void testIsBalanced() {
//		Node root = new Node(100);
//		Node n1 = new Node(50);
//		Node n2 = new Node(200);
//		Node n3 = new Node(125);
//
//        assertTrue(root.isBalanced());
//
//		root.addNode(n1);
//        assertFalse(root.isBalanced());
//
//		root.addNode(n2);
//        assertTrue(root.isBalanced());
//
//		root.addNode(n3);
//        assertFalse(root.isBalanced());
//	}
//
//	@Test
//	public void testGetSuccessor() {
////		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsValidBST() {
//        Node root = null;
//        assertTrue(Node.isValidBST(root));
//		root = new Node(100);
//        assertTrue(Node.isValidBST(root));
//		Node n1 = new Node(50);
//		root.addNode(n1);
//        assertTrue(Node.isValidBST(root));
//		Node n2 = new Node(200);
//		root.addNode(n2);
//        assertTrue(Node.isValidBST(root));
//		Node n3 = new Node(125);
//		root.addNode(n3);
//        assertTrue(Node.isValidBST(root));
//	}
//
//	@Test
//	public void testInOrderTraversalItr() {
//        Node root = null;
//		root = new Node(100);
//		Node n1 = new Node(50);
//		root.addNode(n1);
//		Node n2 = new Node(200);
//		root.addNode(n2);
//		Node n3 = new Node(125);
//		root.addNode(n3);
//
//        StringBuffer inorder = new StringBuffer();
//		for (Iterator i = Node.inOrderIterator(root); i.hasNext();){
//			inorder.append(i.next());
//		}
//		assertTrue(inorder.toString().equals("50 100 125 200 "));
//	}
//}
