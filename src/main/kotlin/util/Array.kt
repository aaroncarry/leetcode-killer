package util

fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[i] xor this[j]
    this[j] = this[i] xor this[j]
    this[i] = this[i] xor this[j]
//    val temp = this[i]
//    this[i] = this[j]
//    this[j] = temp
}