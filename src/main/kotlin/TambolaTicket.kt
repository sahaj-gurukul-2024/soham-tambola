package org.example

class TambolaTicket (
    val topRow: Array<Int>,
    val middleRow: Array<Int>,
    val bottomRow: Array<Int>) {

    fun getRow(rowNumber: Int): Array<Int> {
        return when(rowNumber) {
            1 -> topRow
            2 -> middleRow
            3 -> bottomRow
            else -> throw Exception("Invalid row number")
        }
    }

}