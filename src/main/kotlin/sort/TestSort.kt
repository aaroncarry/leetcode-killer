package sort

import org.junit.Assert
import org.junit.Test
import util.sameAs

class TestSort {
    private val arr = intArrayOf(2, 45, 3462, 34, 6, 34, 754, 45, 6, 2)

    @Test
    fun testSelection() {
        repeat(5) {
            val array1 = Logarithm.generateRandomArray(50, 50)
            val array2 = array1.clone()
            array2.sort()
            SelectionSort.sort(array1)
            Assert.assertTrue(array2.sameAs(array1))
        }
    }

    @Test
    fun testBubble() {
        repeat(5) {
            val array1 = Logarithm.generateRandomArray(50, 50)
            val array2 = array1.clone()
            array2.sort()
            BubbleSort.sort(array1)
            Assert.assertTrue(array2.sameAs(array1))
        }
    }

    @Test
    fun testInsertion() {
        repeat(5) {
            val array1 = Logarithm.generateRandomArray(50, 50)
            val array2 = array1.clone()
            array2.sort()
            InsertionSort.sort(array1)
            Assert.assertTrue(array2.sameAs(array1))
        }
    }

    @Test
    fun testMerge(){
        repeat(5) {
            var array1 = Logarithm.generateRandomArray(50, 50)
            var array2 = array1.clone()
            array1 = MergeSort.sort(array1)
            array2.sort()
            println("Merge sort:${array1.joinToString(",")}")
            Assert.assertTrue(array2.sameAs(array1))
        }
    }
}