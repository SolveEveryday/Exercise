fun main() {
    val preorder = mutableListOf<Int>()
    while (true) {
        val node = readlnOrNull()?.toInt() ?: 0
        if (node == 0) break
        
        preorder.add(node)
    }
    
    val root = makeTree(preorder, 0, 1000000)
    val postorder = getPostorder(root)
    
    print(postorder.joinToString("\n"))
}

fun makeTree(preorder: MutableList<Int>, biggerThan: Int, smallerThan: Int): Node? {
    if (preorder.size == 0) return null
    
    val value = preorder.get(0)
    if (value < biggerThan || value > smallerThan) return null
    
    val root = Node(preorder.removeAt(0))
    root.left = makeTree(preorder, biggerThan, value)
    root.right = makeTree(preorder, value, smallerThan)
    
    return root
}

fun getPostorder(root: Node?): MutableList<String> {
    val postorder = mutableListOf<String>()
    if (root == null) return postorder

    postorder.addAll(getPostorder(root.left))
    postorder.addAll(getPostorder(root.right))
    postorder.add(root.toString())
    
    return postorder
}

class Node(
    val value: Int,
    var left: Node? = null,
    var right: Node? = null
) {
    override fun toString() = value.toString()
}