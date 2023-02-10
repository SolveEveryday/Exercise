import java.util.*

val nodeMap = HashMap<Int, Node>()

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    
    repeat(N-1) {
        val (u, v, distance) = readln().split(" ").map { it.toInt() }
        
        val uNode = getOrCreate(u)
        val vNode = getOrCreate(v)
        uNode.connect(vNode, distance)
        vNode.connect(uNode, distance)
    }
    
    val sb = StringBuilder()
    repeat(M) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        sb.append(getDistance(from, to)).append('\n')
    }
    
    print(sb)
}

fun getDistance(from: Int, to: Int): Int {
    val visited = HashSet<Int>()
    
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(from, 0))
    visited.add(from)
    
    while (queue.size > 0) {
        val (value, accDistance) = queue.poll()
        if (value == to) return accDistance
        
        val node = nodeMap.get(value)!!
        for (edge in node.connected) {
            val (toNode, distance) = edge
            
            if (visited.contains(toNode.value)) continue
            queue.add(Pair(toNode.value, accDistance + distance))
            visited.add(toNode.value)
        }
    }
    
    return -1
}

fun getOrCreate(value: Int): Node {
    if (nodeMap.containsKey(value)) {
        return nodeMap.get(value)!!
    }

    val node = Node(value)
    nodeMap.put(value, node)

    return node
}

class Node(val value: Int) {
    val connected = mutableListOf<Edge>()
    
    fun connect(node: Node, distance: Int) = connected.add(Edge(node, distance))
}

class Edge(val to: Node, val distance: Int) {
    operator fun component1() = to
    operator fun component2() = distance
}