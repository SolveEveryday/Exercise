fun main() {
    val T = readln().toInt()
    repeat(T) {
        val functions = readln()
        readln()
        val strArr = readln()
        
        val ac = AC(strArr)
        ac.operateFuncs(functions)
        println(ac)
    }
}

class AC {
    val deque: ArrayDeque<Int>
    var isNaturalOrder = true
    var isError = false
    
    constructor(strArr: String) {
        deque = ArrayDeque<Int>()
        
        strArr.substring(1, strArr.length-1).split(",")
            .filter { it != "" }
            .map { it.toInt() }
            .forEach { deque.addLast(it) }
    }
    
    fun operateFuncs(functions: String) {
        for (function in functions) {
            operateFunc(function)    
        }
    }
    
    private fun operateFunc(function: Char) = when(function) {
        'R' -> R()
        else -> D()
    }
    
    private fun R() {
        isNaturalOrder = !isNaturalOrder
    }
    
    private fun D() {
        if (deque.isEmpty()) {
            isError = true
            return
        }
    
        if (isNaturalOrder) {
            deque.removeFirst()
        } else {
            deque.removeLast()
        }
    }
    
    override fun toString(): String {
        if (isError) {
            return "error"
        }
    
        if (isNaturalOrder) {
            return deque.joinToString(",", "[", "]")
        } else {
            return deque.reversed().joinToString(",", "[", "]")
        }
    }
}