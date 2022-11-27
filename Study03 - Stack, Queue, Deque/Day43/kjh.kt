fun main() {
    val N = readln().split(" ")[0].toInt()
    val stacks = Array<ArrayDeque<Int>>(7) { ArrayDeque<Int>() }
    
    var fingerMoves = 0
    for (i in 1..N) {
        val (line, fret) = readln().split(" ").map { it.toInt() }
        
        if (stacks[line].isEmpty()) {
            stacks[line].addLast(fret)
            fingerMoves++
            continue
        }
        
        var peek = stacks[line].last()
        while (peek > fret) {
            fingerMoves++
            stacks[line].removeLast()
            if (stacks[line].isEmpty()) {
                peek = -1
                break
            }
            
            peek = stacks[line].last()
        }
        
        if (peek < fret) {
            stacks[line].addLast(fret)
            fingerMoves++
            continue
        }
    }
    
    print(fingerMoves)
}