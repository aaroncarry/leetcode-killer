package sort

import org.junit.Test
import kotlin.math.min

//时间复杂度O(NLogN) 空间复杂度(N)
object MergeSort {
    fun sort(array: IntArray): IntArray {
        if (array.isEmpty() || array.size < 2) {
            return array
        }
        return process(0, array.lastIndex, array)
    }

    private fun process(l: Int, r: Int, array: IntArray): IntArray {
        if (!(l < r && l in 0..array.lastIndex && r in 0..array.lastIndex)) {
            return intArrayOf(array[l])
        }
        val mid = l + ((r - l) shr 1)
        return merge(process(l, mid, array), process(mid + 1, r, array))
    }

    private fun merge(array1: IntArray, array2: IntArray): IntArray {
        val merge = IntArray(array1.size + array2.size)
        var p1 = 0
        var p2 = 0
        for (i in merge.indices) {
            if (p1 <= array1.lastIndex && p2 <= array2.lastIndex) {
                if (array1[p1] <= array2[p2]) {
                    merge[i] = array1[p1]
                    p1++
                } else {
                    merge[i] = array2[p2]
                    p2++
                }
            } else {
                if (p1 > array1.lastIndex) {
                    merge[i] = array2[p2]
                    p2++
                } else {
                    merge[i] = array1[p1]
                    p1++
                }
            }
        }
        return merge
    }
}