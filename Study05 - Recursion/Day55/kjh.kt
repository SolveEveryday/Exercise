import java.util.Stack

class Solution {
    fun solution(brackets: String): String {
        if (isCorrectBracket(brackets)) {
            return brackets
        }
        
        var uvPoint = getUvPoint(brackets)
        
        val u = brackets.substring(0, uvPoint)
        val v = brackets.substring(uvPoint)
        
        if (isCorrectBracket(u)) {
            return u + solution(v)
        } else {
            return "(" + solution(v) + ")" + reverseBrackets(removeFirstLastBracket(u))
        }
    }
    
    fun getUvPoint(brackets: String): Int {
        var opens = 0
        var closes = 0
        
        for (i in 0..brackets.length-1) {
            if (brackets[i]== '(') {
                opens++
            } else {
                closes++
            }
            
            if (opens == closes) {
                return i + 1
            }
        }
        
        return brackets.length
    }
    
    fun isCorrectBracket(brackets: String): Boolean {
        val stack = Stack<Char>()
        
        for (bracket in brackets) {
            if (bracket == '(') {
                stack.push(bracket)
                continue
            }
            
            if (stack.isEmpty()) {
                return false
            }
            stack.pop()
        }
        
        return stack.size == 0
    }
    
    fun removeFirstLastBracket(brackets: String) = brackets.substring(1, brackets.length-1)
    
    fun reverseBrackets(brackets: String): String {
        var reversed = ""
        for (bracket in brackets) {
            if (bracket == '(') {
                reversed += ')'
            } else {
                reversed += '('
            }
        }
        return reversed
    }
}