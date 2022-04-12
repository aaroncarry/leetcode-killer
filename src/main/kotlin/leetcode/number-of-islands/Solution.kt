package leetcode.`number-of-islands`

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var lands = 0
        grid.forEachIndexed { y, chars ->
            chars.forEachIndexed { x, c ->
                lands += if (isLands(x,y,grid)) 1 else 0
            }
        }
        return lands
    }

    fun isLands(x: Int, y: Int, grid: Array<CharArray>): Boolean {
        if (!(x in grid.first().indices && y in grid.indices)) return false
        return if (grid[y][x] == '1') {
            grid[y][x] = '2'
            isLands(x + 1, y, grid)
            isLands(x - 1, y, grid)
            isLands(x, y + 1, grid)
            isLands(x, y - 1, grid)
            true
        } else {
            false
        }
    }
}