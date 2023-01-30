import java.util.*

val dy = arrayOf(-1, 1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)
val dd = arrayOf(Direction.UP_DOWN, Direction.UP_DOWN, Direction.LEFT_RIGHT, Direction.LEFT_RIGHT)

class Solution {
    fun solution(board: Array<IntArray>): Int {
        val minCost = Array(board.size) { Array(board.size) { IntArray(3) { Int.MAX_VALUE } } }
        
        val queue: Queue<Node> = LinkedList<Node>()
        queue.offer(Node(0, 0, Direction.NONE))
        minCost[0][0][0] = 0
        minCost[0][0][1] = 0
        minCost[0][0][2] = 0
        
        while (queue.size > 0) {
            val (y, x, direction) = queue.poll()
            
            for (i in 0..3) {
                val nextY = dy[i] + y
                val nextX = dx[i] + x
                
                val outOfIndex = nextY < 0 || nextX < 0 || nextY >= board.size || nextX >= board.size
                if (outOfIndex) continue
                if (board[nextY][nextX] == 1) continue
                
                val nextDirection = dd[i]
                val nextCost = minCost[y][x][direction.code] + 100 + if (direction.isCorner(nextDirection)) 500 else 0
                
                if (nextCost < minCost[nextY][nextX][nextDirection.code]) {
                    minCost[nextY][nextX][nextDirection.code] = nextCost
                    queue.add(Node(nextY, nextX, nextDirection))
                }
            }
        }
        
        return minCost[board.size-1][board.size-1].minOrNull()!!
    }
}

data class Node(val y: Int, val x: Int, val direction: Direction)

enum class Direction(val code: Int) {
    LEFT_RIGHT(1),
    UP_DOWN(2),
    NONE(0);
    
    fun isCorner(nextDirection: Direction): Boolean {
        return (this == Direction.LEFT_RIGHT && nextDirection == Direction.UP_DOWN)
            || (this == Direction.UP_DOWN && nextDirection == Direction.LEFT_RIGHT)
    }
}