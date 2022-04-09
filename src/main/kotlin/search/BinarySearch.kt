package search

object BinarySearch {
    fun search(array: IntArray, target: Int): Boolean {
        if (array.isEmpty()) return false
        var pL = 0
        var pR = array.lastIndex

        while (pL < pR) {
            val mid = (pL + pR) / 2
            if (target < array[mid]) {
                pR = mid
            } else if (target > array[mid]) {
                pL = mid + 1
            } else {
                return true
            }
        }
        return false
    }
}