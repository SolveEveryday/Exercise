val costs = mutableListOf<List<Int>>()
val minCosts = Array(1000) { IntArray(3) }

fun main() {
    val N = readln().toInt()
    
    repeat(N) {
        costs.add(readln().split(" ").map { it.toInt() })
    }
    
    print(getMinCosts(to = N-1))
}

fun getMinCosts(to: Int): Int {
    var min = Int.MAX_VALUE
    for (color in 0..2) {
        min = Math.min(getMinCosts(to, color), min)
    }
    return min
}

fun getMinCosts(to: Int, color: Int): Int {
    if (to == 0) return costs[to][color]
    if (minCosts[to][color] > 0) return minCosts[to][color]
    
    var minRecursion = Int.MAX_VALUE
    for (c in 0..2) {
        if (c != color) {
            val recursion = getMinCosts(to-1, c)
            minRecursion = Math.min(recursion, minRecursion)
        }
    }
    
    minCosts[to][color] = costs[to][color] + minRecursion
    return minCosts[to][color]
}
