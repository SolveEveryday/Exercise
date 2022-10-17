fun main() {
    val N = readln().toInt()
    
    val numbers = Array<Int>(10001) { 0 }
    for (i in 1..N-1) {
        val number = readln().toInt()
        numbers[number]++
    }
    
    var output = StringBuilder()
    for (i in 1..10000) {
        for (j in 1..numbers[i]) {
            output.append(i).append('\n')
        }
    }
    print(output)
}