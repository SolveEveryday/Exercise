import kotlin.math.pow

fun main() {
    val N = readln().toInt()
    
    val words = mutableListOf<String>()
    repeat(N) {
        val word = readln()
        words.add(word)
    }
    
    val alphabetPriority = hashMapOf<Char, Int>()
    for (word in words) {
        for (digit in word.length-1 downTo 0) {
            val alphabet = word[word.length-digit-1]
            val tenPowDigit = (10.0).pow(digit).toInt()
            
            alphabetPriority += alphabet to (alphabetPriority[alphabet] ?: 0) + tenPowDigit
        }
    }
    
    val topPriorities = alphabetPriority.toList().sortedBy { -it.second }.map { it.first }.toList()
    
    val alphabetToNum = hashMapOf<Char, Int>()
    var num = 9
    for (alphabet in topPriorities) {
        alphabetToNum[alphabet] = num--
    }
    
    var totalWordValue = 0
    for (word in words) {
        var wordValue = 0
    
        var tenPowDigit = (10.0).pow(word.length-1).toInt()
        for (alphabet in word) {
            wordValue += alphabetToNum[alphabet]!! * tenPowDigit
            tenPowDigit /= 10
        }
        
        totalWordValue += wordValue
    }
    
    print(totalWordValue)
}