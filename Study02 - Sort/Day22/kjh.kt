fun main() {
    val N = readln().toInt()
    
    val meetings = ArrayList<Meeting>()    
    repeat(N) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        val meeting = Meeting(start, end)
        meetings.add(meeting)
    }
    
    val sortedMeetings = quickSort(meetings)
    var currentEnd = -1
    var meetingCount = 0
    for (meeting in sortedMeetings) {
        if (meeting.start >= currentEnd) {
            currentEnd = meeting.end
            meetingCount++
        }
    }
    
    print(meetingCount)
}

fun quickSort(items: List<Meeting>): List<Meeting> {
    if (items.size < 2) {
        return items
    }

    val pivot = items[items.size / 2]
    val left = items.filter { it < pivot }
    val right = items.filter { it > pivot }

    return quickSort(left) + items.filter { it == pivot } + quickSort(right)
}

data class Meeting(val start: Int, val end: Int) {
    operator fun compareTo(other: Meeting) = when {
        end != other.end -> end - other.end
        else -> start - other.start
    }
}