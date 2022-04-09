package sort

import util.swap

object BubbleSort {

    fun sort(array: IntArray) {
        for (i in array.indices) {
            for (j in i until array.size) {
                if (array[j] > array[i]) array.swap(i, j)
            }
        }
    }
}