import java.util.*

var connectedNodes = emptyArray<TreeSet<Int>>()
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
    
    bfs(R-1)
    print(visitedOrder.joinToString("\n"))
}

fun bfs(node: Int) {
    val queue: Queue<Int> = LinkedList<Int>()
    
    visitedOrder[node] = order++
    queue.add(node)
    
    while (queue.size > 0) {
        val current = queue.poll()
        for (childNode in connectedNodes[current]) {
            if (visitedOrder[childNode] == 0) {
                visitedOrder[childNode] = order++
                queue.add(childNode)
            }
        }
    }
}