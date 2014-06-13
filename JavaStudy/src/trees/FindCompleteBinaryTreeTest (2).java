package trees;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author vgupta
 *
 */
public class FindCompleteBinaryTreeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		FindCompleteBinaryTree.Node root = new FindCompleteBinaryTree.Node();
		assertEquals(FindCompleteBinaryTree.getDepth(root), 0);
		assertEquals(FindCompleteBinaryTree.getDepthIterative(root), 0);
	}

	@Test
	public void test2() {
		// level 2 tree but partial
		FindCompleteBinaryTree.Node root = new FindCompleteBinaryTree.Node();
		root.left = new FindCompleteBinaryTree.Node();
	
		assertEquals(FindCompleteBinaryTree.getDepth(root), 0);
		assertEquals(FindCompleteBinaryTree.getDepthIterative(root), 0);
	}
	
	@Test
	public void test3() {
		// level 2 tree but partial
		FindCompleteBinaryTree.Node root = new FindCompleteBinaryTree.Node();
		root.left = new FindCompleteBinaryTree.Node();
		root.right = new FindCompleteBinaryTree.Node();
	
		assertEquals(FindCompleteBinaryTree.getDepth(root), 1);
		assertEquals(FindCompleteBinaryTree.getDepthIterative(root), 1);
	}
	
	@Test
	public void test4() {
		// level 2 tree but partial
		FindCompleteBinaryTree.Node root = new FindCompleteBinaryTree.Node();
		root.left = new FindCompleteBinaryTree.Node();
		root.right = new FindCompleteBinaryTree.Node();
	
		root.left.left = new FindCompleteBinaryTree.Node();
		root.left.right = new FindCompleteBinaryTree.Node();
		root.right.left = new FindCompleteBinaryTree.Node();
		root.right.right = new FindCompleteBinaryTree.Node();
		
		assertEquals(FindCompleteBinaryTree.getDepth(root), 2);
		assertEquals(FindCompleteBinaryTree.getDepthIterative(root), 2);
	}
	
	@Test
	public void test5() {
		// level 2 tree but partial
		FindCompleteBinaryTree.Node root = new FindCompleteBinaryTree.Node();
		root.left = new FindCompleteBinaryTree.Node();
		root.right = new FindCompleteBinaryTree.Node();
	
		root.left.left = new FindCompleteBinaryTree.Node();
		root.left.right = new FindCompleteBinaryTree.Node();
		root.right.left = new FindCompleteBinaryTree.Node();
		root.right.right = new FindCompleteBinaryTree.Node();
		
		root.left.left.left = new FindCompleteBinaryTree.Node();
		
		assertEquals(FindCompleteBinaryTree.getDepth(root), 2);
		assertEquals(FindCompleteBinaryTree.getDepthIterative(root), 2);
	}
}
