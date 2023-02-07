package BOJ_1991;

import java.util.*;
import java.io.*;

public class Main2 {
    static class Node {
        char c;
        Node left;
        Node right;

        public Node(char c) {
            this.c = c;
        }
    }

    static Node[] nodes = new Node[27];

    static StringBuilder sb = new StringBuilder();

    public static void preOrder(Node node) {
        if (node == null) return;
        sb.append(node.c);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        sb.append(node.c);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.c);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node((char) (64 + i));
        }

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node parentNode = nodes[parent - 64];
            parentNode.left = (left != '.') ? nodes[left - 64] : null;
            parentNode.right = (right != '.') ? nodes[right - 64] : null;
        }

        preOrder(nodes[1]);
        sb.append('\n');
        inOrder(nodes[1]);
        sb.append('\n');
        postOrder(nodes[1]);
        sb.append('\n');

        System.out.println(sb);
    }
}