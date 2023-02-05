val nodeMap = HashMap<String, Node>()

fun main() {
    val N = readln().toInt()
    
    repeat(N) {
        val (root, left, right) = readln().split(" ")
        val rootNode = getOrCreate(root)
        val leftNode = if (left == ".") null else getOrCreate(left)
        val rightNode = if (right == ".") null else getOrCreate(right)
        
        rootNode.left = leftNode
        rootNode.right = rightNode
    }
    
    val root = nodeMap.get("A")
    println(traversePreorder(root))
    println(traverseInorder(root))
    println(traversePostorder(root))
}

fun traversePreorder(root: Node?): String {
    if (root == null) return ""

    val leftSubtree = traversePreorder(root.left)
    val rightSubtree = traversePreorder(root.right)
    
    return root.value + leftSubtree + rightSubtree
}

fun traverseInorder(root: Node?): String {
    if (root == null) return ""

    val leftSubtree = traverseInorder(root.left)
    val rightSubtree = traverseInorder(root.right)
    
    return leftSubtree + root.value + rightSubtree
}

fun traversePostorder(root: Node?): String {
    if (root == null) return ""

    val leftSubtree = traversePostorder(root.left)
    val rightSubtree = traversePostorder(root.right)
    
    return leftSubtree + rightSubtree + root.value
}

fun getOrCreate(value: String): Node {
    if (nodeMap.containsKey(value)) {
        return nodeMap.get(value)!!
    }

    val node = Node(value)
    nodeMap.put(value, node)

    return node
}

class Node(val value: String, var left: Node? = null, var right: Node? = null)