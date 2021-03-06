package sort

import util.swap

//不稳定性排序
object SelectionSort {
    fun sort(arr: IntArray) {
        var minIndex = 0
        for (i in arr.indices) {
            minIndex = i
            for (j in i until arr.size) {
                if (arr[minIndex] > arr[j]) minIndex = j
            }
            if (minIndex != i) arr.swap(minIndex, i)
        }
    }
}