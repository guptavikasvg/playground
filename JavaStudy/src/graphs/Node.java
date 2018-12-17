package graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private int data;
	private List<Node> children;

	public Node(int i) {
        data = i;
        setChildren(new ArrayList<Node>());
	}
	
	public void addChild(Node n){
		getChildren().add(n);
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "[" + data + ']';
	}
}