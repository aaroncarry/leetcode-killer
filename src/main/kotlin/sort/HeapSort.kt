package sort

import util.swap

/**
 * 完全二叉树
 * i 下标的左孩子 2i + 1
 *        右孩子 2i + 2
 *        父节点 (i-1)/2
 */
object HeapSort {
    fun sort(array: IntArray) {
        array.forEachIndexed { index, i ->
            heapInsert(index, array)
        }
        var heapSize = array.size
        while (heapSize > 0) {
            array.swap(0, --heapSize)
            heapify(heapSize, 0, array)
        }
    }

    fun heapify(heapSize: Int, index: Int, array: IntArray) {
        var leftChildIndex = 2 * index + 1
        var tempIndex = index
        while (leftChildIndex < heapSize) {
            val maxChildIndex = if (leftChildIndex + 1 < heapSize) {
                if (array[leftChildIndex] >= array[leftChildIndex + 1]) leftChildIndex else leftChildIndex + 1
            } else {
                leftChildIndex
            }
            if (array[tempIndex] > array[maxChildIndex]) {
                return
            } else {
                array.swap(tempIndex, maxChildIndex)
                tempIndex = maxChildIndex
                leftChildIndex = 2 * tempIndex + 1
            }
        }
    }

    private fun heapInsert(index: Int, array: IntArray) {
        var parentIndex = findParent(index)
        var insertIndex = index

        while (array[parentIndex] < array[insertIndex]) {
            array.swap(parentIndex, insertIndex)
            insertIndex = parentIndex
            parentIndex = findParent(insertIndex)
        }
    }

    private fun findParent(index: Int): Int {
        return (index - 1) / 2
    }
}