import java.util.*

val dy = arrayOf(-1, +1, 0, 0)
val dx = arrayOf(0, 0, -1, +1)

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    
    val maze = mutableListOf<CharArray>()
    repeat(N) {
        maze.add(readln().toCharArray())
    }
    
    val queue: Queue<Node> = LinkedList<Node>()
    queue.add(Node(0, 0, 1))
    
    while (queue.size > 0) {
        val (y, x, depth) = queue.poll()
        if (maze[y][x] == '0') continue
        maze[y][x] = '0'
        
        for (i in 0..3) {
            val aroundY = dy[i] + y
            val aroundX = dx[i] + x
            
            val outOfIndex = aroundY < 0 || aroundX < 0 || aroundY >= N || aroundX >= M
            if (outOfIndex) continue
            if (maze[aroundY][aroundX] == '0') continue
            if (aroundY == N-1 && aroundX == M-1) {
                print(depth + 1)
                return
            }
            queue.add(Node(aroundY, aroundX, depth + 1))
        }
    }
}

data class Node(val y: Int, val x: Int, val depth: Int)
