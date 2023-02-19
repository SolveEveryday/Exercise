class Solution {
    public int solution(int[][] board, int[][] skill) {        
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n + 1][m + 1];
        
        for (int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            
            int degree = (type == 1) ? -s[5] : s[5];
            
            sum[r1][c1] += degree;
            sum[r2 + 1][c2 + 1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
        
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[j][i] += sum[j - 1][i];
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}