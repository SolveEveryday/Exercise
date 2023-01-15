var nodes = emptyArray<Node>()
var visited = emptyArray<Boolean>()

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    
    nodes = Array(N) { num -> Node(num) }
    repeat(M) {
        val (n1, n2) = readln().split(" ").map { it.toInt() }
        nodes[n1].connect(nodes[n2])
        nodes[n2].connect(nodes[n1])
    }
    
    for (i in 0..N-1) {
        val node = nodes[i]
        
        visited = Array(N) { false }
        val maxDepth = getMaxDepth(node)
        if (maxDepth >= 5) {
            print(1)
            return
        }
    }
    
    print(0)
}

fun getMaxDepth(node: Node): Int {
    visited[node.num] = true

    var childMaxDepth = 0
    for (child in node.connected) {
        if (visited[child.num]) continue
        
        val childDepth = getMaxDepth(child)
        if (childDepth >= 4) return 5
        
        childMaxDepth = Math.max(childMaxDepth, childDepth)
    }
    
    visited[node.num] = false
    return childMaxDepth + 1
}

data class Node(val num: Int, val connected: MutableList<Node> = mutableListOf<Node>()) {
    fun connect(node: Node) {
        connected.add(node)
    }
}