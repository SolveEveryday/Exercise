fun main() {
    val MAX_NUMBER = 10000000
    val NUMBER_RANGE = 20000001

    readln()
    
    val sanggeun = Array<Boolean>(NUMBER_RANGE) { false }
    val cardsSangguen = readln().split(" ").map { it.toInt() }
    for (card in cardsSangguen) {
        sanggeun[card + MAX_NUMBER] = true
    }
    
    readln()
    
    val results = StringBuilder()
    val cards = readln().split(" ").map { it.toInt() }
    for (card in cards) {
        val result = if (sanggeun[card + MAX_NUMBER] == true) 1 else 0
        results.append(result).append(" ")
    }
    print(results)
}