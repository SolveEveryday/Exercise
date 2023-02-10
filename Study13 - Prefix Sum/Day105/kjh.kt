fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    
    val numbers = readln().split(" ").map { it.toInt() }
    val prefixSum = IntArray(N+1)
    for (i in 1..N) {
        prefixSum[i] = prefixSum[i-1] + numbers[i-1]
    }
    
    val sb = StringBuilder()
    repeat(M) {
        val (i, j) = readln().split(" ").map { it.toInt() }
        val result = prefixSum[j] - prefixSum[i-1]
        sb.append(result).append('\n')
    }
    print(sb)
}