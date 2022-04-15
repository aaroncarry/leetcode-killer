package sort

import org.junit.Test
import util.swap

// 随机数下，数学期望 NLogN
// 无随机数情况，最差情况，单调序列 O(n*n) -> 由于划分值打得很偏
// 空间复杂度 O(N) -> O(logN)
object QuickSort {
    fun sort(array: IntArray) {
        rec(0, array.lastIndex, array)
    }

    fun rec(l: Int, r: Int, array: IntArray) {
        if (!(l in array.indices && r in array.indices && l < r)) return

        val arr = partition(l, r, array)
        rec(l, arr[0], array)
        rec(arr[1], r, array)
    }

    fun partition(l: Int, r: Int, array: IntArray): IntArray {
        val k = array[r]
        var p1 = l - 1
        var p2 = l
        var p3 = r
        while (p2 < p3) {
            if (array[p2] < k) {
                array.swap(p2, ++p1)
                p2++
            } else if (array[p2] > k) {
                array.swap(p2, --p3)
            } else {
                p2++
            }
        }
        array.swap(r, p2)
        println(array.joinToString(","))
        return intArrayOf(p1, p2)
    }
}