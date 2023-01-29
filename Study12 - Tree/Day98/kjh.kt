fun main() {
    val N = readln().toInt()
    if (N == 1) {
        print(0)
        return
    }
    
    val nodeMap = HashMap<Int, Node>()
    repeat(N-1) {
        val (a, b, distance) = readln().split(" ").map { it.toInt() }
    
        val nodeA = getOrCreateNode(nodeMap, a)
        val nodeB = getOrCreateNode(nodeMap, b)
        
        val aToB = Edge(nodeB, distance)
        nodeA.addEdge(aToB)
        
        val bToA = Edge(nodeA, distance)
        nodeB.addEdge(bToA)
    }
    
    val root = nodeMap.get(1)!!
    convertGraphToTree(root)
    
    print(getMaxDistance(root))
}

fun getOrCreateNode(nodeMap: HashMap<Int, Node>, value: Int): Node {
    if (nodeMap.containsKey(value)) {
        return nodeMap.get(value)!!
    }
    
    val node = Node(value)
    nodeMap.put(value, node)
    
    return node
}

fun convertGraphToTree(root: Node) {
    for (edge in root.edges) {
        val child = edge.connectedNode
        child.removeEdge(root.value)
        convertGraphToTree(child)
    }
}

fun getMaxDistance(root: Node): Long {
    var maxDistance = 0L
    
    for (edge in root.edges) {
        val distance = edge.distance + getMaxDistance(edge.connectedNode)
        maxDistance = Math.max(distance, maxDistance)
    }
    
    return maxDistance
}

class Node(val value: Int) {
    val edges = mutableListOf<Edge>()

    fun addEdge(edge: Edge) = edges.add(edge)
    
    fun removeEdge(valueOfTarget: Int) {
        val targetEdge = edges.filter { it.connectedNode.value == valueOfTarget }.firstOrNull()
        targetEdge ?: return
        edges.remove(targetEdge)
    }
}

data class Edge(val connectedNode: Node, val distance: Int)