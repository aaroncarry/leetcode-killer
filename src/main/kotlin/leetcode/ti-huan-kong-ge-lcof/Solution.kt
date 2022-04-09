package leetcode.`ti-huan-kong-ge-lcof`

//https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
class Solution {
    //这题有点脱裤子放屁的感觉，懒得做，最优做法应该是先计算出空格数，然后算出需要的空间数，从后到前移动字符串，时间复杂度n
    fun replaceSpace(s: String): String {
        return s.replace(" ","%20")
    }
}