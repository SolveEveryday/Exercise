val ALPHABETS = 'z'-'a'+1

fun main() {
    val S = readln()

    val accSum = Array(ALPHABETS) { IntArray(S.length+1) }
    for (i in 1..S.length) {
        val alphabet = S[i-1]
        val alphabetIdx = alphabet - 'a' + 1
        
        for (j in 0..ALPHABETS-1) {
            accSum[j][i] = accSum[j][i-1]
        }
        accSum[alphabetIdx][i] = accSum[alphabetIdx][i] +  1
    }
    
    val sb = StringBuilder()
    
    val Q = readln().toInt()
    repeat(Q) {
        var query = readln().split(" ")
        
        val alphabetIdx = query[0][0] - 'a' + 1
        val from = query[1].toInt() + 1
        val to = query[2].toInt() + 1
        
        sb.append(accSum[alphabetIdx][to] - accSum[alphabetIdx][from-1])
          .append('\n')
    }
    print(sb)
}