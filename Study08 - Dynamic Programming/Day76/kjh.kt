fun main() {
    val N = readln().toInt()

    val glasses = mutableListOf<Int>()
    repeat(N) {
        val ml = readln().toInt()
        glasses.add(ml)
    }
    
    val dp = Array(N + 1) { IntArray(3) }
    dp[1][1] = glasses[0]
    
    var maxMl = dp[1][1]
    for (i in 2..N) {
        dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + glasses[i-1]
        if (i >= 3) {
            dp[i][1] = Math.max(dp[i][1], Math.max(dp[i-3][1], dp[i-3][2]) + glasses[i-1])
        }
        
        dp[i][2] = dp[i-1][1] + glasses[i-1]
        
        maxMl = Math.max(maxMl, Math.max(dp[i][1], dp[i][2]))
    }
    
    print(maxMl)
}