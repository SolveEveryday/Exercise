import java.util.PriorityQueue

fun main() {
    val N = readln().toInt()
    val M = readln().toInt()
    
    val adj = Array(N) { mutableListOf<Edge>() }
    repeat(M) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        adj[u-1].add(Edge(v-1, w))
    }
    
    val (A, B) = readln().split(" ").map { it.toInt() }
    
    val shortestDistance = IntArray(N) { Int.MAX_VALUE }
    shortestDistance[A-1] = 0
    
    val pq = PriorityQueue<Edge>()
    pq.offer(Edge(A-1, 0))
    
    while (pq.size > 0) {
        val (curIdx, curDistance) = pq.poll()
        if (shortestDistance[curIdx] < curDistance) continue
        
        for (edge in adj[curIdx]) {
            val nextIdx = edge.toIdx
            val nextDistance = curDistance + edge.distance
            
            if (nextDistance < shortestDistance[nextIdx]) {
                shortestDistance[nextIdx] = nextDistance
                pq.offer(Edge(nextIdx, nextDistance))
            }
        }
    }
    
    print(shortestDistance[B-1])
}

class Edge(val toIdx: Int, val distance: Int): Comparable<Edge> {
    override operator fun compareTo(other: Edge) = distance - other.distance
    
    operator fun component1() = toIdx
    
    operator fun component2() = distance
}