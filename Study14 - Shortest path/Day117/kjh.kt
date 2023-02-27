import java.util.PriorityQueue

fun main() {
    val (M, N) = readln().split(" ").map { it.toInt() }
    
    val maze = Array(N) { IntArray(M) }
    for (i in 0..N-1) {
        val line = readln()
        for (j in 0..M-1) {
            maze[i][j] = line[j] - '0'
        }
    }
    
    val pq = PriorityQueue<Path>()
    pq.offer(Path(0, 0, 0))
    
    val shortestDistance = Array(N) { IntArray(M) { Int.MAX_VALUE } }
    shortestDistance[0][0] = 0
    
    val dy = arrayOf(-1, 1, 0, 0)
    val dx = arrayOf(0, 0, -1, 1)
    while (pq.size > 0) {
        val (currentY, currentX, accumulatedDistance) = pq.poll()
        if (accumulatedDistance > shortestDistance[currentY][currentX]) continue
        
        for (i in 0..3) {
            val nextY = currentY + dy[i]
            val nextX = currentX + dx[i]
            
            val outOfIndex = nextY < 0 || nextX < 0 || nextY >= maze.size || nextX >= maze[0].size
            if (outOfIndex) continue
            
            val nextDistance = accumulatedDistance + maze[nextY][nextX]
            if (nextDistance < shortestDistance[nextY][nextX]) {
                shortestDistance[nextY][nextX] = nextDistance
                pq.offer(Path(nextY, nextX, nextDistance))
            }
        }
    }
    
    print(shortestDistance[N-1][M-1])
}

data class Path(val currentY: Int, val currentX: Int, val accumulatedDistance: Int): Comparable<Path> {
    override operator fun compareTo(other: Path) = accumulatedDistance - other.accumulatedDistance
}