fun main() {
    val (N, K, B) = readln().split(" ").map { it.toInt() }
    
    val trafficLights = IntArray(N + 1) { 1 }
    trafficLights[0] = 0
    repeat(B) {
        val broken = readln().toInt()
        trafficLights[broken] = 0
    }
    
    val accSum = IntArray(N + 1)
    for (i in 1..N) {
        accSum[i] = accSum[i-1] + trafficLights[i]
    }
    
    var maxPrefixSum = 0
    for (i in 1..N-K+1) {
        for (j in i..i+K-1) {
            val prefixSum = accSum[j] - accSum[i-1]
            maxPrefixSum = Math.max(prefixSum, maxPrefixSum)
        }
    }
    
    print(K - maxPrefixSum)
}
