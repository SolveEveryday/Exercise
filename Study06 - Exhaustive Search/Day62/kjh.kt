fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    
    val board = ArrayList<String>()
    repeat(N) {
        val row = readln()
        board.add(row)
    }
    
    var answer = 64
    for (startY in 0..N-8) {
        for (startX in 0..M-8) {
            answer = Math.min(countRequiredRepaint(board, 'B', startY, startX), answer)
            answer = Math.min(countRequiredRepaint(board, 'W', startY, startX), answer)
        }
    }
    
    print(answer)
}

fun countRequiredRepaint(board: ArrayList<String>, startColor: Char, startY: Int, startX: Int): Int {
    var count = 0

    for (i in startY..startY+7) {
        val line = board[i]
        for (j in startX..startX+7) {
            val color = line[j]
            
            val repaintRequired: Boolean
            if ((i+j) % 2 == 0) {
                repaintRequired = color != startColor
            } else {
                repaintRequired = color == startColor
            }
            
            if (repaintRequired) {
                count++
            }
        }
    }
    
    return count
}
