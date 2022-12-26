val lines = ArrayList<List<Int>>()

fun main() {
    val N = readln().toInt()

    repeat(N) {
        val line = readln().split(" ").map { it.toInt() }
        lines.add(line)
    }
    
    print(twotwotwoPull(size = N, startY = 0, startX = 0))
}

fun twotwotwoPull(size: Int, startY: Int, startX: Int): Int {
    if (size == 1) {
        return lines[startY][startX]
    }
    
    val leftTop = twotwotwoPull(size / 2, startY, startX)
    val rightTop = twotwotwoPull(size / 2, startY, startX + size/2)
    val leftBottom = twotwotwoPull(size / 2, startY + size/2, startX)
    val rightBottom =  twotwotwoPull(size / 2, startY + size/2, startX + size/2)
    
    return getSecondLargest(leftTop, rightTop, leftBottom, rightBottom)
}

fun getSecondLargest(vararg nums: Int) = nums.sorted()[2]
