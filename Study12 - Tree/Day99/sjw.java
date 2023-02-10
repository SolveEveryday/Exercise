import java.util.*;

class Node {
	char val;
	Node left, right;
	Node(char val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class Main {
	static StringBuilder pre = new StringBuilder();
	static StringBuilder in = new StringBuilder();
	static StringBuilder post = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Character, Node> nodes = new HashMap<>();

		for (int i = 0; i < n; i++) {
			char parent = sc.next().charAt(0);
			char left = sc.next().charAt(0);
			char right = sc.next().charAt(0);
			Node parentNode = nodes.getOrDefault(parent, new Node(parent));
			nodes.put(parent, parentNode);
			if (left != '.') {
				Node leftNode = nodes.getOrDefault(left, new Node(left));
				parentNode.left = leftNode;
				nodes.put(left, leftNode);
			}
			if (right != '.') {
				Node rightNode = nodes.getOrDefault(right, new Node(right));
				parentNode.right = rightNode;
				nodes.put(right, rightNode);
			}
		}
		preorder(nodes.get('A'));
		inorder(nodes.get('A'));
		postorder(nodes.get('A'));
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}

	public static void preorder(Node root) {
		if (root == null) return;
		pre.append(root.val);
		preorder(root.left);
		preorder(root.right);
	}

	public static void inorder(Node root) {
		if (root == null) return;
		inorder(root.left);
		in.append(root.val);
		inorder(root.right);
	}

	public static void postorder(Node root) {
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		post.append(root.val);
	}
}