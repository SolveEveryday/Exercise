// [백준] 11000. 강의실 배정 (Kotlin)
import java.util.*
import kotlin.collections.ArrayList

// 강의 클래스
data class C(
    val start: Int,
    val end: Int,
)

fun main() = with(Scanner(System.`in`)){
    val n = nextInt() // 수업 개수
    val arr = ArrayList<C>() // 수업 리스트
    val room = PriorityQueue<Int>() // 강의실

    // 강의 입력
    for(i in 0 until n){
        arr.add(C(nextInt(),nextInt()))
    }

//    arr.sortBy { it.end }
    arr.sortBy { it.start }

    // 강의 입력
    for(i in 0 until n){
        // 처음 강의 넣어주기
        if(i == 0){
            room.add(arr[i].end)
        }
        else{
            // 가장 빨리 끝나는 강의에 넣을 수 있다면 (기존 강의실 사용)
            if(room.peek() <= arr[i].start){
                room.poll()
                room.add(arr[i].end)
            }
            // 새로운 강의실 사용
            else{
                room.add(arr[i].end)
            }
        }
    }

    println(room.size)
}