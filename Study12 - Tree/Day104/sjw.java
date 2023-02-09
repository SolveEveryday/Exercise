import java.util.*;

class Solution {

	class Node {
		public int idx;
		public int x;
		public int y;
		public Node left;
		public Node right;

		Node(int idx, int x, int y) {
			this.idx = idx;
			this.x = x;
			this.y = y;
		}

		public void makeTree(Node node) {
			if (this.x < node.x) { // 오른쪽
				if (this.right == null)
					this.right = node;
				else
					this.right.makeTree(node);
			} else { // 왼쪽
				if (this.left == null)
					this.left = node;
				else
					this.left.makeTree(node);
			}
		}
	}

	public int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][nodeinfo.length];
		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < nodeinfo.length; i++) {
			nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
		}

		nodes.sort((a, b) -> {
			if (a.y == b.y) {
				return Integer.compare(a.x, b.x); // 오름차순
			}
			return Integer.compare(b.y, a.y); // 내림차순
		});

		Node root = nodes.get(0);

		for (int i = 1; i < nodes.size(); i++) {
			root.makeTree(nodes.get(i));
		}

		List<Integer> preList = new ArrayList<>();
		preOrder(preList, root);
		answer[0] = preList.stream().mapToInt(i -> i).toArray();

		List<Integer> postList = new ArrayList<>();
		postOrder(postList, root);
		answer[1] = postList.stream().mapToInt(i -> i).toArray();

		return answer;
	}

	public void preOrder(List<Integer> answer, Node node) {
		if (node == null) {
			return;
		}
		answer.add(node.idx);
		preOrder(answer, node.left);
		preOrder(answer, node.right);
	}

	public void postOrder(List<Integer> answer, Node node) {
		if (node == null) {
			return;
		}
		postOrder(answer, node.left);
		postOrder(answer, node.right);
		answer.add(node.idx);
	}

}