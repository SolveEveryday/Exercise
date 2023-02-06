val nodeMap = HashMap<Int, Node>()

fun main() {
    val (N, R, Q) = readln().split(" ").map { it.toInt() }
    
    repeat(N-1) {
        val (U, V) = readln().split(" ").map { it.toInt() }
        
        val nodeU = getOrCreate(U)
        val nodeV = getOrCreate(V)
        
        nodeU.connect(nodeV)
        nodeV.connect(nodeU)
    }
    
    val root = getOrCreate(R)
    discoverSubtreeSizes(root)
    
    val sb = StringBuilder()
    repeat(Q) {
        val target = readln().toInt()
        val targetNode = nodeMap.get(target)!!
        
        sb.append(targetNode.subtreeSize).append('\n')
    }

    print(sb)
}

fun discoverSubtreeSizes(root: Node): Int {
    var subtreeSize = 1
    for (child in root.connected) {
        child.disconnect(root)
        subtreeSize += discoverSubtreeSizes(child)
    }
    
    root.subtreeSize = subtreeSize
    return subtreeSize
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
    val connected = mutableListOf<Node>()
    var subtreeSize = 0
    
    fun connect(node: Node) = connected.add(node)
    
    fun disconnect(node: Node) = connected.remove(node)
}