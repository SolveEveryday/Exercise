import java.util.PriorityQueue

fun main() {
    val (N, M, X) = readln().split(" ").map { it.toInt() }
    
    val adj = Array(N) { mutableListOf<Edge>() }
    val reversedAdj = Array(N) { mutableListOf<Edge>() }
    
    repeat(M) {
        val (from, to, time) = readln().split(" ").map { it.toInt() }
        
        adj[from-1].add(Edge(to-1, time))
        reversedAdj[to-1].add(Edge(from-1, time))
    }
    
    val homeToParty = getShortestTimes(reversedAdj, X-1)
    val partyToHome = getShortestTimes(adj, X-1)
    
    val shortestTimes = IntArray(N)
    for (i in 0..N-1) {
        shortestTimes[i] = homeToParty[i] + partyToHome[i]
    }
    
    print(shortestTimes.maxOrNull() ?: -1)
}

fun getShortestTimes(adj: Array<MutableList<Edge>>, startIdx: Int): IntArray {
    val shortestTimes = IntArray(adj.size) { Int.MAX_VALUE }
    shortestTimes[startIdx] = 0
    
    val pq = PriorityQueue<Edge>()
    pq.offer(Edge(startIdx, 0))
    
    while (pq.size > 0) {
        val (curIdx, accDistance) = pq.poll()
        if (accDistance > shortestTimes[curIdx]) continue
        
        for (edge in adj[curIdx]) {
            val nextIdx = edge.destIdx
            val nextAccDistance = shortestTimes[curIdx] + edge.distance
            
            if (nextAccDistance < shortestTimes[nextIdx]) {
                shortestTimes[nextIdx] = nextAccDistance
                pq.offer(Edge(nextIdx, nextAccDistance))
            }
        }
    }
    
    return shortestTimes
}

data class Edge(val destIdx: Int, val distance: Int): Comparable<Edge> {
    override operator fun compareTo(other: Edge) = distance - other.distance
}