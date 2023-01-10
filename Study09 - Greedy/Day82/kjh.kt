fun main() {
    val S = readln()
    var T = readln()
    
    while (T.length != S.length) {
        val (last, rest) = Pair(T.last(), T.substring(0, T.length-1))
        
        if (last == 'B') {
            T = rest.reversed()
        } else {
            T = rest
        }
    }
    
    if (T == S) {
        print(1)
    } else {
        print(0)
    }
}