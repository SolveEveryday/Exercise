fun main() {
    val (r, c, k) = readln().split(" ").map { it.toInt() }
    
    val arr = Array(101) { IntArray(101) { 0 } }
    for (row in 1..3) {
        val nums = readln().split(" ").map { it.toInt() }
        for (col in 1..3) {
            arr[row][col] = nums[col-1]
        }
    }
    
    var minutes = 0
    while (arr[r][c] != k && minutes <= 100) {
        operate(arr)
        minutes++
    }
    
    if (minutes > 100) {
        print(-1)
        return
    }
    print(minutes)
}

fun operate(arr: Array<IntArray>) {
    val rowSize = getRowSize(arr)
    val colSize = getColSize(arr)
    if (rowSize >= colSize) {
        operateR(arr, rowSize, colSize)
        return
    }
    operateC(arr, rowSize, colSize)
}

fun getRowSize(arr: Array<IntArray>): Int {
    loop@ for (row in 1..100) {
        for (col in 1..100) {
            if (arr[row][col] > 0) {
                continue@loop
            }
        }
        return row-1
    }
    return 100
}

fun getColSize(arr: Array<IntArray>): Int {
    loop@ for (col in 1..100) {
        for (row in 1..100) {
            if (arr[row][col] > 0) {
                continue@loop
            }
        }
        return col-1
    }
    return 100
}

fun operateR(arr: Array<IntArray>, rowSize: Int, colSize: Int) {
    for (row in 1..rowSize) {
        val numbers = ArrayList<Int>()
        for (col in 1..colSize) {
            val number = arr[row][col]
            if (number > 0) {
                numbers.add(arr[row][col])
            }
        }
        
        val operated = operateNumbers(numbers)
        for (col in 1..operated.size) {
            arr[row][col] = operated[col-1]
        }
        for (col in operated.size+1..colSize) {
            arr[row][col] = 0
        }
    }
}

fun operateC(arr: Array<IntArray>, rowSize: Int, colSize: Int) {
    for (col in 1..colSize) {
        val numbers = ArrayList<Int>()
        for (row in 1..rowSize) {
            val number = arr[row][col]
            if (number > 0) {
                numbers.add(arr[row][col])
            }
        }
        
        val operated = operateNumbers(numbers)
        for (row in 1..operated.size) {
            arr[row][col] = operated[row-1]
        }
        for (row in operated.size+1..rowSize) {
            arr[row][col] = 0
        }
    }
}

fun operateNumbers(numbers: ArrayList<Int>): ArrayList<Int> {
    val operated = ArrayList<Int>();

    var numberAndCount = Array<NumberAndCount>(101) { NumberAndCount(0, 0) }
    for (number in numbers) {
        if (number == 0) continue
        if (numberAndCount[number].number == 0) {
            numberAndCount[number].number = number
            numberAndCount[number].count = 1
            continue
        }
        numberAndCount[number].count++
    }
    
    val sorted = quickSort(numberAndCount.toList())
    for (item in sorted) {
        if (item.number == 0) continue
        operated.add(item.number)
        operated.add(item.count)
    }
    
    return operated
}

fun quickSort(list: List<NumberAndCount>): List<NumberAndCount> {
    if (list.size < 2) {
        return list
    }

    val pivot = list[list.size / 2]
    val left = list.filter { it < pivot }
    val right = list.filter { it > pivot }

    return quickSort(left) + listOf(pivot) + quickSort(right)
}

data class NumberAndCount(var number: Int, var count: Int) {
    operator fun compareTo(other: NumberAndCount) = when {
        count != other.count -> count - other.count
        else -> number - other.number
    }
}