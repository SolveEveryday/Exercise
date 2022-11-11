import java.util.Stack

fun main() {
    val brokenBrackets = readln()
    
    var requiredBrackets = 0
    val stack = Stack<Char>()
    for (bracket in brokenBrackets) {
        if (bracket == '(') {
            stack.push(bracket)
            continue
        }
        
        if (stack.isEmpty()) {
            requiredBrackets++
            continue
        }
        stack.pop()
    }
    requiredBrackets += stack.size
    
    print(requiredBrackets)
}