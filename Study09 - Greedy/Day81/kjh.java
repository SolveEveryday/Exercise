import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
        
        List<Integer> cameras = new ArrayList<>();
        for (int[] route : routes) {
            int lastCamera = cameras.size() == 0 ? 30001 : cameras.get(cameras.size()-1);
            if (lastCamera >= route[0] && lastCamera <= route[1]) continue;
            
            cameras.add(route[1]);
        }
        
        return cameras.size();
    }
}