package sort

import org.junit.Test

class TestSort {
    private val arr = intArrayOf(2, 45, 3462, 34, 6, 34, 754, 45, 6, 2)

    @Test
    fun testSelection() {
        val temp = arr.clone()
        SelectionSort.sort(temp)
        println(temp.joinToString(","))
    }

    @Test
    fun testBubble() {
        val temp = arr.clone()
        BubbleSort.sort(temp)
        println(temp.joinToString(","))
    }
}