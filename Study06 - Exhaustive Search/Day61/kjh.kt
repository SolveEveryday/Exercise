val joolNumbers = ArrayList<Long>()

fun main() {
    val digits = mutableListOf(9L, 8L, 7L, 6L, 5L, 4L, 3L, 2L, 1L, 0L)

    for (n in 1..9) {
        joolNumbers.addAll(makeNDigitsCombinations(digits, n))
    }
    joolNumbers.add(9876543210L)
    
    joolNumbers.sort()
    
    val N = readln().toInt()
    if (N <= joolNumbers.size) {
        print(joolNumbers[N-1])
    } else {
        print(-1)
    }
}

fun makeNDigitsCombinations(digits: MutableList<Long>, n: Int) : MutableList<Long>  {
    if (n == 1) {
        return digits
    }
    
    val combinations = mutableListOf<Long>()
    for (i in 0..digits.size-1) {
        val digit = digits[i]
        
        val smallDigits = if (i < digits.size-1) digits.subList(i+1, digits.size) else mutableListOf<Long>()
        val recursion = makeNDigitsCombinations(smallDigits, n-1)
        
        for (combination in recursion) {
            combinations.add(digit * Math.pow(10.0, n-1.0).toLong() + combination)
        }
    }
    
    return combinations
}