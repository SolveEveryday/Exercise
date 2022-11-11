import java.util.Stack

fun main() {
    val brackets = readln()
    val stack = Stack<Char>()
    
    var pieces = 0
    var isPrevOpening = false
    for (bracket in brackets) {
        if (bracket == '(') {
            stack.push('(')
            isPrevOpening = true
            continue
        }
        
        stack.pop()
        if (isPrevOpening) {
            pieces += stack.size
        } else {
            pieces++
        }
        isPrevOpening = false
    }
    
    print(pieces)
}