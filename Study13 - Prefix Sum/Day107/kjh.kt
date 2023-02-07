fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    
    val accSum = Array(N+1) { IntArray(N+1) }
    for (y in 1..N) {
        val line = readln().split(" ").map { it.toInt() }
        for (x in 1..N) {
            accSum[y][x] = accSum[y-1][x] + accSum[y][x-1] + line[x-1] - accSum[y-1][x-1]
        }
    }
    
    val sb = StringBuilder()
    repeat(M) {
        val (y1, x1, y2, x2) = readln().split(" ").map { it.toInt() }
        val pSum = accSum[y2][x2] - accSum[y2][x1-1] - accSum[y1-1][x2] + accSum[y1-1][x1-1]
        sb.append(pSum).append('\n')
    }
    
    print(sb)
}
