import java.util.Stack

fun main() {
    val N = readln().toInt()
    
    val result = StringBuilder()
    repeat(N) {
        val brackets = readln()
        
        if (isVPS(brackets)) {
            result.append("YES")
        } else {
            result.append("NO")
        }
        result.append('\n')
    }
    print(result)
}

fun isVPS(brackets: String): Boolean {
    val stack = Stack<Char>()
    for (bracket in brackets) {
        if (bracket == '(') {
            stack.push('(')
        } else {
            if (stack.empty()) {
                return false
            }
            stack.pop()
        }
    }
    
    return stack.empty()
}