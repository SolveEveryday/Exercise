package BOJ_5639;

import java.util.*;
import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Tree tree = new Tree();
        while ((input = br.readLine()) != null) {
            tree.insert(Integer.parseInt(input));
        }

        StringBuilder sb = new StringBuilder();
        tree.postOrder(tree.root, sb);
        System.out.println(sb);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static class Tree {
        Node root;

        public void postOrder(Node node, StringBuilder sb) {
            if (node == null) return;

            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(node.value).append('\n');
        }

        public void insert(int value) {
            if (root == null) {
                root = new Node(value);
                return;
            }

            Node temp = root;
            while (true) {
                if (value < temp.value) {
                    if (temp.left == null) {
                        temp.left = new Node(value);
                        return;
                    }
                    temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = new Node(value);
                        return;
                    }
                    temp = temp.right;
                }
            }
        }
    }
}
