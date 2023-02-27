import java.util.PriorityQueue

var adj = emptyArray<MutableList<Edge>>()

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }

    adj = Array(N) { mutableListOf<Edge>() }

    repeat(M) {
        val (from, to, distance) = readln().split(" ").map { it.toInt() }

        adj[from-1].add(Edge(to-1, distance))
        adj[to-1].add(Edge(from-1, distance))
    }

    val (A, B) = readln().split(" ").map { it.toInt() }
    val aToB = getShortestDistance(0, A-1) + getShortestDistance(A-1, B-1) + getShortestDistance(B-1, N-1)
    val bToA = getShortestDistance(0, B-1) + getShortestDistance(B-1, A-1) + getShortestDistance(A-1, N-1)
    
    val shortest = Math.min(aToB, bToA)
    if (shortest == Int.MAX_VALUE) {
        print(-1)
    } else {
        print(shortest)
    }
}

fun getShortestDistance(from: Int, to: Int): Int {
    val shortestDistance = IntArray(adj.size) { Int.MAX_VALUE }
    shortestDistance[from] = 0

    val pq = PriorityQueue<Edge>()
    pq.offer(Edge(from, 0))

    while (pq.size > 0) {
        val (curIdx, accDistance) = pq.poll()
        if (accDistance > shortestDistance[curIdx]) continue

        for (edge in adj[curIdx]) {
            val nextIdx = edge.destIdx
            val nextAccDistance = shortestDistance[curIdx] + edge.distance

            if (nextAccDistance < shortestDistance[nextIdx]) {
                shortestDistance[nextIdx] = nextAccDistance
                pq.offer(Edge(nextIdx, nextAccDistance))
            }
        }
    }

    return shortestDistance[to]
}

data class Edge(val destIdx: Int, val distance: Int): Comparable<Edge> {
    override operator fun compareTo(other: Edge) = distance - other.distance
}