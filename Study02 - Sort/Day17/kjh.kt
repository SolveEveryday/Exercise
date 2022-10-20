fun main() {
    val N = readln().toInt()
    
    val serials = ArrayList<SerialNumber>()
    repeat(N) {
        val serial = readln()
        serials.add(SerialNumber(serial))
    }
    
    val sorted = quickSort(serials)
    
    for (serial in sorted) {
        println(serial)
    }
}

fun quickSort(serials: List<SerialNumber>): List<SerialNumber> {
    if (serials.size < 2) {
        return serials
    }

    val pivot = serials[serials.size / 2]
    val left = serials.filter { it < pivot }
    val right = serials.filter { it > pivot }

    return quickSort(left) + listOf(pivot) + quickSort(right)
}

data class SerialNumber(val serial: String) {
    val length: Int
        get() {
            return serial.length
        }
    
    val digitsSum: Int
        get() {
            return serial.toCharArray().map { char -> if (char.isDigit()) { Character.getNumericValue(char) } else { 0 } }
                .reduce { sum, num -> sum + num }
        }

    operator fun compareTo(other: SerialNumber) = when {
        length != other.length -> length - other.length
        digitsSum != other.digitsSum -> digitsSum - other.digitsSum
        else -> serial.compareTo(other.serial)
    }
    
    override fun toString() = serial
}