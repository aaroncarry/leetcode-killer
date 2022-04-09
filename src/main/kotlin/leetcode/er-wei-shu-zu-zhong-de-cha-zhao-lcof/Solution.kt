package leetcode.`er-wei-shu-zu-zhong-de-cha-zhao-lcof`

/**
 * [
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
]

https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 */
class Solution {
    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false
        var x = matrix.first().size - 1
        var y = 0
        while (x >= 0 && y < matrix.size) {
            if (matrix[y][x]<target)
                y++
            else if (matrix[y][x]>target)
                x--
            else
                return true
        }
        return false
    }

    //暴力递归法直接给干超时了，日了狗，轻易不能用暴力搜索，除非到时候实在写不出来了
    private fun recursion(x: Int, y: Int, matrix: Array<IntArray>, target: Int): Boolean {
        if (!(y in matrix.indices && x in matrix.first().indices)) {
            return false
        }
        return if (matrix[y][x] < target) {
            recursion(x, y + 1, matrix, target) || recursion(x + 1, y, matrix, target)
        } else matrix[y][x] <= target
    }
}