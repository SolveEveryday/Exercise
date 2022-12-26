val boxes = ArrayList<Int>()
val maxBoxes = IntArray(1000)

fun main() {
    val N = readln().toInt()
    readln().split(" ").map { boxes.add(it.toInt()) }
    
    var maxOfMax = 0
    for (toIdx in 0..N-1) {
        maxOfMax = Math.max(getMaxBoxes(toIdx), maxOfMax)
    }
    
    print(maxOfMax)
}

fun getMaxBoxes(lastBoxIdx: Int): Int {
    if (lastBoxIdx < 0) return 0
    if (maxBoxes[lastBoxIdx] > 0) return maxBoxes[lastBoxIdx]
    
    var recursionMax = 0
    for (i in 0..lastBoxIdx-1) {
        if (boxes[i] < boxes[lastBoxIdx]) {
            val recursion = getMaxBoxes(i)
            recursionMax = Math.max(recursion, recursionMax)
        }
    }
    
    maxBoxes[lastBoxIdx] = recursionMax + 1
    return maxBoxes[lastBoxIdx]
}
