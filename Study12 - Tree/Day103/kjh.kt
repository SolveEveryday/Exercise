val nodeMap = mutableMapOf<Int, Node>()

fun main() {
    val N = readln().toInt()
    repeat(N-1) {
        val (parent, child, distance) = readln().split(" ").map { it.toInt() }
        val parentNode = getOrCreate(parent)
        val childNode = getOrCreate(child)
        
        parentNode.addChild(childNode, distance)
    }
    
    val root = nodeMap.get(1)
    if (root == null) {
        print(0)
        return
    }
    
    discoverDiametersAndReturnMaxDepth(root)
    
    val maxDiameter = nodeMap.values.map { it.diameter }.maxByOrNull { it }!!
    print(maxDiameter)
}

fun discoverDiametersAndReturnMaxDepth(root: Node): Int {
    val childrenMaxDepth = mutableListOf<Int>()
    for (child in root.children) {
        val childMaxDepth = discoverDiametersAndReturnMaxDepth(child.node) + child.distance
        childrenMaxDepth.add(childMaxDepth)
    }
    
    val diameter = childrenMaxDepth.sortedBy { it }.takeLast(2).sum()
    root.diameter = diameter
    
    return childrenMaxDepth.maxByOrNull { it } ?: 0
}

fun getOrCreate(value: Int) = nodeMap.getOrPut(value) { Node(value) }

class Node(val value: Int) {
    val children = mutableListOf<Edge>()
    var diameter = 0
    
    fun addChild(node: Node, distance: Int) = children.add(Edge(node, distance))
}

class Edge(val node: Node, val distance: Int)