fun main() {
    val target = readln()
    
    val usedCount = Array<Int>('Z'-'A'+1) { 0 }
    for (c in target) {
        val idx = c - 'A'
        usedCount[idx]++
    }
    val (oddUsedCount, oddUsedLetter) = getOddUsedInfo(usedCount)

    val canBePalindrome = (target.length % 2 == 0 && oddUsedCount == 0)
                            || (target.length % 2 == 1 && oddUsedCount == 1)
    if (!canBePalindrome) {
        print("I'm Sorry Hansoo")
        return
    }
    
    var left = ""
    for (i in 0 until usedCount.size) {
        val count = usedCount[i]
        val letter = ('A'+i).toChar().toString()
        if (count == 0) { continue }
        left += letter.repeat(count / 2)
    }
    
    val middle = oddUsedLetter
    val right = left.reversed()
    
    print("$left$middle$right")
}

fun getOddUsedInfo(usedCount: Array<Int>): OddUsedInfo {
    var oddUsedCount = 0
    var oddUsedLetter = ""

    for (i in 0 until usedCount.size) {
        val count = usedCount[i]
        val letter = ('A'+i).toChar().toString()
        
        if (count % 2 == 1) {
            oddUsedCount++
            oddUsedLetter += letter
        }
    }
    
    return OddUsedInfo(oddUsedCount, oddUsedLetter)
}

data class OddUsedInfo(val oddUsedCount: Int, val oddUsedLetter: String)