import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        List<Long> list = new ArrayList<>();
        long sum1 = 0;
        long sum2 = 0;

        // 합 구하기
        for(int i = 0 ; i < queue1.length ; i ++){
            sum1 += (long) queue1[i];
            sum2 += (long) queue2[i];
        }

        if(sum1 == sum2) return 0;
        else if((sum1 + sum2) % 2 != 0) return -1;
        else if(sum2 > sum1) return solution(queue2, queue1);

        long target = (sum1 + sum2) / 2;
        for(int i = 0 ; i < queue1.length ; i ++) list.add((long)queue1[i]);
        for(int i = 0 ; i < queue2.length ; i ++) list.add((long)queue2[i]);
        for(int i = 0 ; i < queue1.length ; i ++) list.add((long)queue1[i]);
        for(int i = 0 ; i < queue2.length ; i ++) list.add((long)queue2[i]);

        int i = 0;
        int j = queue1.length;
        int ans = 0;
        while(i != j && i < queue1.length * 2 && j < list.size()){
            while(sum1 > target && i < queue1.length * 2){
                sum1 -= list.get(i++);
                ans ++;
            } 

            while(sum1 < target && j < list.size()){
                sum1 += list.get(j++);
                ans ++;
            } 

            if(sum1 == target) return ans;
        }

        return -1;
    }

}