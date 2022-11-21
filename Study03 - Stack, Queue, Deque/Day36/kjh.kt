import java.util.*

fun main() {
    val brackets = readln()
    
    val solution = Solution(brackets)
    
    val answer = solution.get()
    if (solution.error) {
        print(0)
    } else {
        print(answer)
    }
}

class Solution(val brackets: String) {
    var idx = 0
    val stack = Stack<Char>()
    var error = false

    fun get(): Int {
        var stacked = 0
        while (idx < brackets.length) {
            val bracket = brackets[idx]
            if (isOpen(bracket)) {
                stack.push(bracket)
                idx += 1
                stacked += getCost(bracket) * get()
                continue
            }
            
            if (stack.size == 0) {
                return error()
            }
            
            if (isPair(stack.peek(), bracket)) {
                stack.pop()
                idx += 1
                return Math.max(1, stacked)
            }
            
            return error()
        }
        
        if (stack.size > 0) {
            return error()
        }
        return stacked
    }

    private fun error(): Int {
        error = true
        return -1
    }
    
    private fun isOpen(bracket: Char): Boolean {
        return bracket == '(' || bracket == '['    
    }
    
    private fun getCost(bracket: Char) = when(bracket) {
        '(', ')' -> 2
        else -> 3
    }
    
    private fun isPair(bracket1: Char, bracket2: Char): Boolean {
        return getCost(bracket1) == getCost(bracket2)
    }
}
