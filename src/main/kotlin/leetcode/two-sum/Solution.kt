package leetcode.`two-sum`

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int,Int>()
        nums.forEachIndexed { index, i ->
            val k = target - i
            if (map.containsKey(k)){
                return intArrayOf(map[k]!!, index)
            }else{
                map[i] = index
            }
        }
        return intArrayOf(0)
    }

}