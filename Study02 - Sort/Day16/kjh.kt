fun main() {
    val MAX_NUMBER = 1000000
    val NUMBER_RANGE = 2000001
    
    val N = readln().toInt()
    val existsNumbers = Array<Boolean>(NUMBER_RANGE) { false }

    for (i in 0..N-1) {
        val number = readln().toInt()
        existsNumbers[number + MAX_NUMBER] = true
    }

    val result = StringBuilder()
    for (i in 0..NUMBER_RANGE-1) {
        if (existsNumbers[i]) {
            result.append(i - MAX_NUMBER).append('\n')
        }
    }
    print(result)
}