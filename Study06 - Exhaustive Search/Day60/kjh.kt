fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    
    val cards = ArrayList<String>(n)
    repeat(n) {
        val card = readln()
        cards.add(card)
    }
    
    val mixed = mixCards(cards, k)
    print(mixed.size)
}

fun mixCards(cards: ArrayList<String>, pickCount: Int): Set<String> {
    if (pickCount == 1) {
        return cards.toSet()
    }

    val mixed = HashSet<String>()
    for (i in 0..cards.size-1) {
        val card = cards.removeAt(i)
        
        val recursion = mixCards(cards, pickCount-1)
        for (cardsStr in recursion) {
            mixed.add(card + cardsStr)
        }
        
        cards.add(i, card)
    }
    
    return mixed
}
