package search

object RecursionSearch {

    fun max(array: IntArray): Int {
        return process(0, array.lastIndex, array)
    }

    private fun process(l: Int, r: Int, array: IntArray): Int {
        if (l == r) return array[l]
        val mid = l + ((r - l) shr 1)
        return kotlin.math.max(process(l, mid, array), process(mid + 1, r, array))
    }
}