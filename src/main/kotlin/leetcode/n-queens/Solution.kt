package leetcode.`n-queens`

import org.junit.Test

class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        val result = arrayListOf<List<String>>()
        for (i in 0 until n) {
            process(arrayListOf(i), 1, n, result)
        }
        return result
    }

    private fun process(location: ArrayList<Int>, cur: Int, n: Int, result: ArrayList<List<String>>) {
        if (cur >= n) {
            val resultList = arrayListOf<String>()
            location.forEach {
                val build = StringBuilder()
                for (index in 0 until n) {
                    if (index == it) {
                        build.append("Q")
                    } else {
                        build.append(".")
                    }
                }
                resultList.add(build.toString())
            }
            result.add(resultList)
            return
        }
        for (i in 0 until n) {
            if (isValidLocation(location, i, cur, n)) {
                val clone = location.clone() as ArrayList<Int>
                clone.add(i)
                process(clone, cur + 1, n, result)
            }
        }
    }

    private fun isValidLocation(location: ArrayList<Int>, x: Int, y: Int, n: Int): Boolean {
        if (!(x < n && y <= n)) return false
        location.forEachIndexed { index, i ->
            if (i == x) return false
            if (index == y) return false
            val offset = (x - i) / Math.abs(x - i) * Math.abs(index - y)
            if ((i + offset) == x) return false
        }
        return true
    }


    @Test
    fun test() {
        solveNQueens(4)
    }
}