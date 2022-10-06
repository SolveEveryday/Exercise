import java.util.*;

class Solution {
    public int reverse(int x) {
        if (x == 0) return x;
        
        int sign = (x >= 0) ? +1 : -1;
        
        String tmp = removeSign(x);
        System.out.print(tmp);
        tmp = reverse(tmp);
        tmp = removeFrontZeros(tmp);
        tmp = addSign(tmp, sign);
        
        if (isOutOfIntRange(tmp)) {
            return 0;
        }
        return Integer.valueOf(tmp);
    }
    
    private String removeSign(int num) {
        return String.valueOf(Math.abs((long) num));
    }
    
    private String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }
    
    private String removeFrontZeros(String str) {
        int nonZeroBeginIdx = 0;
        while (str.charAt(nonZeroBeginIdx) == '0') {
            nonZeroBeginIdx++;
        }
        return str.substring(nonZeroBeginIdx);
    }
    
    private String addSign(String str, int sign) {
        if (sign == -1) return "-" + str;
        return str;
    }
    
    private boolean isOutOfIntRange(String strNum) {
        long num = Long.valueOf(strNum);
        return num < Integer.MIN_VALUE || num > Integer.MAX_VALUE;
    }
}