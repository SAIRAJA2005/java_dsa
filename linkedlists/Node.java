package linkedlists;

public class Node {
	Person data;
	Node link;

	public Node() {
		super();
		link = null;
	}

	public Node(Person data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}

	public Person getData() {
		return data;
	}

	public void setData(Person data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

}
