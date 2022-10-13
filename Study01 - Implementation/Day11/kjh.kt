fun main() {
    val (N, M, L) = readln().split(" ").map { it.toInt() }

    val receivedCounts = Array(N, {0})
    receivedCounts[0] = 1
    
    var thrownCount = 0
    var ballIdx = 0
    while (true) {
        if (receivedCounts[ballIdx] >= M) {
            break
        }
    
        if (receivedCounts[ballIdx] % 2 == 1) {
            ballIdx = (ballIdx + L) % N
        } else {
            ballIdx = (N + ballIdx - L) % N
        }
        
        thrownCount++
        receivedCounts[ballIdx]++
    }
    print(thrownCount)
}