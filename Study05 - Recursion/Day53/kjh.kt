val moves = ArrayList<String>()

fun main() {
    val N = readln().toInt()
    
    hanoi(N, 1, 2, 3)
    println(moves.size)
    print(moves.joinToString("\n"))
}

fun hanoi(n: Int, from: Int, tmp: Int, to:Int) {
    if (n == 1) {
        moves.add("$from $to")
        return
    }
    
    hanoi(n-1, from, to, tmp)
    hanoi(1, from, tmp, to)
    hanoi(n-1, tmp, from, to)
}