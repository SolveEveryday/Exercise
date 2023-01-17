import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        bfs(a, b);
    }

    static void bfs(long a, long b) {
        Queue<Long> q = new LinkedList<>();
        q.add(a * 2);
        q.add(10 * a + 1);

        int answer = 0;

        while (!q.isEmpty()) {
            answer++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long x = q.poll();
                if (x > b) {
                    continue;
                }
                if(x == b){
                    System.out.println(answer + 1);
                    return;
                }
                q.add(x * 2);
                q.add(10 * x + 1);
            }
        }
        System.out.println(-1);
    }
}