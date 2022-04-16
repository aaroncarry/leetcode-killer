package newcode

import org.junit.Test
import java.util.*

//使用优先级队列实现大小根堆
class Heap {
    fun getMinHeap(): PriorityQueue<Int> {
        return PriorityQueue<Int>()
    }

    fun getMaxHeap(): PriorityQueue<Int> {
        return PriorityQueue<Int> { o1, o2 -> o2 - o1 }
    }

    @Test
    fun test() {
        val heap = getMaxHeap()
        heap.add(3)
        heap.add(2)
        heap.add(5)
        heap.add(8)
        heap.add(234)
        heap.add(-12)
        heap.add(6)
        while (heap.isNotEmpty()) {
            val node = heap.poll()
            println(node)
        }
    }
}