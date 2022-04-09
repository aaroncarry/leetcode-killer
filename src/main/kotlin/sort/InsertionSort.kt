package sort

import util.swap

//插入排序是稳定排序
object InsertionSort {
    fun sort(array: IntArray) {
        if (array.isEmpty() || array.size < 2) {
            return
        }
        for (i in 1 until array.size) {
            for (j in i downTo 1) {
                if (array[j] < array[j - 1]) {
                    array.swap(j, j - 1)
                } else {
                    break
                }
            }
        }
    }
}