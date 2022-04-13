package sort

import org.junit.Test

object Logarithm {

    fun generateRandomArray(maxSize: Int, maxValue: Int): IntArray {
        val intArray = IntArray(((maxSize + 1) * Math.random()).toInt())
        for (i in intArray.indices) {
            intArray[i] = ((maxValue + 1) * Math.random()).toInt() - (maxValue * Math.random()).toInt()
        }
        println("Generate random array[${intArray.joinToString(",")}]")
        return intArray
    }

    @Test
    private fun test(){
        generateRandomArray(50,50)
    }
}