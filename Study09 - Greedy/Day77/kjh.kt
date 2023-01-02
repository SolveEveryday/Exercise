fun main() {
    val N = readln().toInt()
    val jeongEun = readln().toInt()
    val votes = mutableListOf<Int>()
    repeat(N-1) {
        votes.add(readln().toInt())
    }
    
    var red = 0
    while (votes.count { it >= jeongEun + red } > 0) {
        val maxVote = votes.maxByOrNull { it }
        val rival = votes.indexOfFirst { it == maxVote }
        votes[rival]--
        
        red++
    }
    
    print(red)
}