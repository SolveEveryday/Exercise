import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static class Node {
		int num;
		Node left, right;

		Node(int num) {
			this.num = num;
		}

		void insert(int n) {
			if (n < this.num) {
				if (this.left == null)
					this.left = new Node(n);
				else this.left.insert(n);
			} else {
				if (this.right == null)
					this.right = new Node(n);
				else this.right.insert(n);
			}
		}
		void postorder(Node node) {
			if(node.left != null) postorder(node.left);
			if(node.right != null) postorder(node.right);
			System.out.println(node.num);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node node = new Node(Integer.parseInt(br.readLine()));;
		String input;

		while(true) {
			input = br.readLine();
			if(input == null || "".equals(input)) {
				break;
			}
			node.insert(Integer.parseInt(input));
		}
		node.postorder(node);
	}
}
