package leetcode.`shu-zu-zhong-de-ni-xu-dui-lcof`

import org.junit.Test

// 太难了。。。写得头都要裂了才写出来
class Solution {
    companion object {
        var count = 0
    }

    fun reversePairs(nums: IntArray): Int {
        count =0
        if (nums.isEmpty()) return 0
        process(0, nums.lastIndex, nums)
        return count
    }

    fun process(l: Int, r: Int, nums: IntArray): IntArray {
        if (!(l in nums.indices && r in nums.indices && l < r)) return intArrayOf(nums[l])
        val mid = l + ((r - l) shr 2)
        return merge(process(l, mid, nums), process(mid + 1, r, nums))
    }

    fun merge(arrayL: IntArray, arrayR: IntArray): IntArray {
        val merge = IntArray(arrayL.size + arrayR.size)
        var pL = 0
        var pR = 0
        var index = 0
        while ((pL in arrayL.indices) && (pR in arrayR.indices)) {
            if (arrayL[pL] <= arrayR[pR]) {
                merge[index] = arrayL[pL]
                pL++
            } else {
                merge[index] = arrayR[pR]
                pR++
                count += (arrayL.size - pL)
            }
            index++
        }
        while (pL in arrayL.indices) {
            merge[index] = arrayL[pL]
            index++
            pL++
        }
        while (pR in arrayR.indices) {
            merge[index] = arrayR[pR]
            index++
            pR++
        }
        return merge
    }

    @Test
    fun test() {
        val intArray = intArrayOf(2,4,3,5,1)
        println( reversePairs(intArray))
    }
}
