package pro_62048;

public class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        for (int i = 0; i < w; i++) {
            double temp = ((double) h * (double) i) / w;
            answer += (long) temp;
        }
        return answer * 2;
    }
}
