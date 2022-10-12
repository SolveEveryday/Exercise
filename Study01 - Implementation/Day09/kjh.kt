class Solution {
    fun solution(w: Int, h: Int): Long {
        var n = Math.min(w, h)
        var m = Math.max(w, h)
        
        val gcd = getGCD(n, m)
        n /= gcd
        m /= gcd
        
        val cutSquares = n*(m/n+1)+(m%n)-1
        
        val result: Long = w.toLong() * h - (gcd * cutSquares)
        return result
    }
    
    fun getGCD(a: Int, b: Int): Int = if(b != 0) getGCD(b, a % b) else a
}