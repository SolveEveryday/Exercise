fun main() {
    val n = readln().toInt()
    
    var count = 0
    repeat(n) {
        val word = readln()
        if (isGroupWord(word)) {
            count++
        }
    }
    
    print(count)
}

fun isGroupWord(word: String) : Boolean {
    val usedLetter = Array<Boolean>('z'-'a'+1) { false }

    for (i in 0 until word.length) {
        val prevLetter = if (i == 0) '\u0000' else word[i-1]
        val letter = word[i]
        
        val isUsedLetter = usedLetter[letter-'a']
        if ((prevLetter != letter) && isUsedLetter) {
            return false
        }
        usedLetter[letter-'a'] = true
    }
    return true
}