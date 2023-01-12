import java.util.*

class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {        
        val connectedIslands = Array(n) { mutableSetOf<Int>() }
        for (i in 0..n-1) {
            connectedIslands[i].add(i)
        }
        
        var totalCost = 0
        val sortedByLessCost = costs.sortedBy { it[2] }
        for (connectInfo in sortedByLessCost) {
            val (island1, island2, cost) = connectInfo

            val island1Children = getConnectedChildren(island1, connectedIslands)
            val island2Children = getConnectedChildren(island2, connectedIslands)
            
            val alreadyConnected = island1Children.subtract(island2Children).size == 0
            if (alreadyConnected) continue
            
            connectedIslands[island1].addAll(island2Children)
            connectedIslands[island2].addAll(island1Children)
            
            totalCost += cost
            println(connectedIslands.joinToString())
            
            val connectedCount = connectedIslands.map { it.size }.maxOrNull()!!
            if (connectedCount == n) {
                break
            }
        }
        
        return totalCost
    }
    
    fun getConnectedChildren(island: Int, connectedIslands: Array<MutableSet<Int>>): Set<Int> {
        val connectedChildren = mutableSetOf<Int>()
        connectedChildren.add(island)
        connectedChildren.addAll(connectedIslands[island])
        
        val visited = BooleanArray(connectedIslands.size)        
        val queue: Queue<Int> = LinkedList<Int>()
        queue.addAll(connectedIslands[island])
        
        while (queue.size > 0) {
            val current = queue.poll()
            visited[current] = true
            
            for (child in connectedIslands[current]) {
                if (visited[child]) continue
                queue.add(child)
                connectedChildren.add(child)
            }
        }
        
        return connectedChildren
    }
}