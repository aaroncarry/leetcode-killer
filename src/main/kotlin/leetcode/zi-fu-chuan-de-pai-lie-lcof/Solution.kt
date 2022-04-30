package leetcode.`zi-fu-chuan-de-pai-lie-lcof`

import org.junit.Test

class Solution {
    fun permutation(s: String): Array<String> {
        val res = ArrayList<String>()
        process(s.toCharArray(), 0, res)
        return res.toTypedArray()
    }

    private fun process(chars: CharArray, cur: Int, resKeep: ArrayList<String>) {
        if (cur == chars.lastIndex) {
            resKeep.add(chars.joinToString(""))
            return
        }
        val set = hashSetOf<Char>()
        for (i in cur..chars.lastIndex) {
            if (set.contains(chars[i])){
                continue
            }
            set.add(chars[i])
            chars.swap(cur, i)
            process(chars, cur + 1, resKeep)
            chars.swap(i, cur)
        }
    }

    private fun CharArray.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }


    @Test
    fun test(){
        permutation("abc")
    }
}