package pro_42884;


import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int solution(int[][] routes) {

        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int answer = 0;
        int temp = -30001;

        for (int[] route : routes) {
            if (route[0] > temp) {
                temp = route[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
        System.out.println(new Solution().solution(new int[][]{{-20,-15}, {-15,-5}, {-5,0}}));

    }
}
