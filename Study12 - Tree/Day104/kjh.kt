class Solution {
    var nodes = mutableListOf<Node>()
    
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        for (i in 0..nodeinfo.size-1) {
            val (x, y) = nodeinfo[i]
            val node = Node(i+1, y, x)
            nodes.add(node)
        }
        nodes.sort()
        
        val root = nodes[0]
        makeTree(root)
        
        val preorder = traversePreorder(root)
        val postorder = traversePostorder(root)
        return arrayOf(preorder.toIntArray(), postorder.toIntArray())
    }
    
    fun makeTree(root: Node) = makeTree(root, 0, 100000)
    
    fun makeTree(root: Node?, moreThan: Int, lessThan: Int) {
        if (root == null) return
        
        val childY = nodes.firstOrNull { it.y < root.y }?.y
        if (childY == null) return
        
        val children = nodes.filter { it.y == childY && it.x >= moreThan && it.x <= lessThan }
        
        val left = children.find { it.x < root.x }
        val right = children.find { it.x > root.x }
        
        root.left = left
        root.right = right
        
        makeTree(root.left, moreThan, root.x-1)
        makeTree(root.right, root.x+1, lessThan)
    }
    
    fun traversePreorder(root: Node?): List<Int> {
        if (root == null) return emptyList<Int>()

        val leftSubtree = traversePreorder(root.left)
        val rightSubtree = traversePreorder(root.right)

        return listOf(root.value) + leftSubtree + rightSubtree
    }

    fun traversePostorder(root: Node?): List<Int> {
        if (root == null) return emptyList<Int>()

        val leftSubtree = traversePostorder(root.left)
        val rightSubtree = traversePostorder(root.right)
        
        return leftSubtree + rightSubtree + listOf(root.value)
    }
}

class Node(val value: Int, val y: Int, val x: Int, var left: Node? = null, var right: Node? = null): Comparable<Node> {
    override fun compareTo(other: Node) = when {
        y != other.y -> other.y.compareTo(y)
        else -> x.compareTo(other.x)
    }
    
    override fun toString() = value.toString()
}