import java.util.*

var connectedNodes = Array(0) { TreeSet<Int>() }
var visitedOrder = IntArray(0)
var order = 1

fun main() {
    val (N, M, R) = readln().split(" ").map { it.toInt() }
    visitedOrder = IntArray(N)
    connectedNodes = Array(N) { TreeSet<Int>() }
    
    repeat(M) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        connectedNodes[u-1].add(v-1)
        connectedNodes[v-1].add(u-1)
    }
    
    dfs(R-1)
    print(visitedOrder.joinToString("\n"))
}

fun dfs(node: Int) {
    visitedOrder[node] = order++
    for (childNode in connectedNodes[node]) {
        if (visitedOrder[childNode] == 0) {
            dfs(childNode)
        }
    }
}