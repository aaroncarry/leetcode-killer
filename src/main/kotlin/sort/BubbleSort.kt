package sort

import util.swap

object BubbleSort {

    fun sort(array: IntArray) {
        for (i in array.size - 1 downTo 0) {
            for (j in 0 until i) {
                if (array[j] > array[j + 1]) array.swap(j, j + 1)
            }
        }
    }
}