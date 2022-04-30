package leetcode.`longest-substring-without-repeating-characters`

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val chars = s.toCharArray()
        val set = hashSetOf<Char>()
        var p1 = 0
        var p2 = 0
        var maxLength = 0
        while (p2 < chars.size) {
            if (!set.contains(chars[p2])) {
                set.add(chars[p2])
                p2++
            } else {
                while (chars[p1] != chars[p2]) {
                    set.remove(chars[p1])
                    p1++
                }
                set.add(chars[p2])
                p1++
                p2++
            }
            maxLength = Math.max(maxLength, p2 - p1)
        }
        return maxLength
    }
}