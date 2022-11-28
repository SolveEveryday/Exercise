fun main() {
    val expression = readln()
    val deque = splitNumAndOperator(expression)
    
    while (deque.size > 1) {
        val frontResult = operate(deque[0], deque[1], deque[2])
        val backResult = operate(deque[deque.lastIndex-2], deque[deque.lastIndex-1], deque[deque.lastIndex])
        
        val isFrontPriority = deque[1] == "*" || deque[1] == "/"
        val isBackPriority = deque[deque.lastIndex-1] == "*" || deque[deque.lastIndex-1] == "/"
        val backWin = (isBackPriority && !isFrontPriority) ||
            (isBackPriority == isFrontPriority && backResult > frontResult)
        
        if (backWin) {
            repeat(3) { deque.removeLast() }
            deque.addLast(backResult.toString())
        } else {
            repeat(3) { deque.removeFirst() }
            deque.addFirst(frontResult.toString())
        }
    }
    
    val result = deque[0].toLong()
    print(result)
}

fun operate(strNum1: String, oper: String, strNum2: String): Long {
    val (num1, num2) = Pair(strNum1.toLong(), strNum2.toLong())
    val result = when (oper) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num1 / num2
        else -> throw IllegalStateException()
    }
    return result
}

fun splitNumAndOperator(expression: String): ArrayDeque<String> {
    val deque = ArrayDeque<String>()
    
    var sbNum = StringBuilder()
    for (oper in expression) {
        val isNegativeSign = sbNum.length == 0 && oper == '-'
        val isDigit = oper.isDigit()
        if (isNegativeSign || isDigit) {
            sbNum.append(oper)
            continue
        }
        
        deque.add(sbNum.toString())
        deque.add(oper.toString())
        sbNum.clear()
    }
    
    if (sbNum.length > 0) {
        deque.add(sbNum.toString())
    }
    
    return deque
}
