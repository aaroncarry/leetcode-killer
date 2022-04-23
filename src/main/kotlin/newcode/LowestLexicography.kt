package newcode

import org.junit.Test

class LowestLexicography {

    fun lowest(array: Array<String>): String {
        array.sortWith { o1, o2 -> (o1 + o2).compareTo(o2 + o1) }
        return array.joinToString("")
    }

    @Test
    fun test(){
        val array = arrayOf("b","ba")
        lowest(array)
    }
}