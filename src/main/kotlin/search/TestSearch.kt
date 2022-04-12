package search

import org.junit.Assert
import org.junit.Test
import sort.Logarithm

class TestSearch {
    private val array = intArrayOf(2, 2, 6, 6, 34, 34, 45, 45, 754, 3462)

    @Test
    fun testBinary(){
        Assert.assertTrue(BinarySearch.search(array,6))
        Assert.assertFalse(BinarySearch.search(array,72))
    }

    @Test
    fun max(){
        val a = Logarithm.generateRandomArray(50,50)
        Assert.assertTrue(a.maxOrNull() == RecursionSearch.max(a))
    }
}