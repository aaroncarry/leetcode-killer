package util

fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

//object Array {
//    fun swap(i: Int, j: Int, arr: IntArray) {
//        val temp = arr[i]
//        arr[i] = arr[j]
//        arr[j] = temp
//    }
//}