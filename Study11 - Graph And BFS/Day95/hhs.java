package pro_67259;

import java.util.*;

public class Solution {
    static class Node {
        int y, x, cost;
        char direction;

        public Node(int y, int x, int cost, char direction) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.direction = direction;
        }
    }

    static char[] directions = {'L', 'R', 'D', 'U'};
    static int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int N, answer = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        N = board.length;
        bfs(new Node(0, 0, 0, 'R'), board);
        bfs(new Node(0, 0, 0, 'D'), board);
        return answer;
    }

    public static void bfs(Node startNode, int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        int[][] visited = new int[N][N];
        visited[startNode.y][startNode.x] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.y == N - 1 && node.x == N - 1) {
                answer = Math.min(answer, node.cost);
            }

            for (int i = 0; i < 4; i++) {
                char newDirection = directions[i];
                int moveY = node.y + move[i][0];
                int moveX = node.x + move[i][1];

                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N) {
                    int newCost = calDirection(node.direction, newDirection, node.cost);
                    if (board[moveY][moveX] != 1 && (visited[moveY][moveX] == 0 || visited[moveY][moveX] > newCost)) {
                        queue.add(new Node(moveY, moveX, newCost, newDirection));
                        visited[moveY][moveX] = newCost;
                    }
                }
            }
        }
    }

    public static int calDirection(char start, char end, int cost) {
        if ((start == 'R' || start == 'L') && (end == 'L' || end == 'R')) {
            return cost + 100;
        } else if ((start == 'D' || start == 'U') && (end == 'U' || end == 'D')) {
            return cost + 100;
        } else if ((start == 'R' || start == 'L') && (end == 'U' || end == 'D')) {
            return cost + 600;
        } else {
            return cost + 600;
        }
    }

    public static void main(String[] args) {
        new Solution().solution(new int[][]{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}});
    }
}
