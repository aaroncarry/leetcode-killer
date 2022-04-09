package newcode

import org.junit.Test

class LocalMinimum {
    fun min(array: IntArray): Int {
        if (array.isEmpty() || array.size < 2) return 0
        if (array[0] < array[1]) return 0
        if (array.last() < array[array.lastIndex - 1]) return array.lastIndex
        var pL = 0
        var pR = array.lastIndex
        while (pL < pR) {
            val mid = (pL + pR) / 2
            if (array[mid] > array[mid - 1]) {
                pR = mid
            } else if (array[mid] > array[mid + 1]) {
                pL = mid + 1
            } else {
                return mid
            }
        }
        return 0
    }

    @Test
    fun test() {
        val array = intArrayOf(5535435, 45345, 5431, 64, 7, 6, 5, 52)
        println(this.min(array))
    }
}