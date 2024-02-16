package org.example

class Tambola() {
    private var crossedNumberCount = 0

    fun rowValidation(
        ticket: TambolaTicket,
        numbersAnnounced: ArrayList<Int>,
        rowNumber: Int
    ): Boolean {
        var currentNumberCount = 0

        while (currentNumberCount < numbersAnnounced.size) {
            if (numbersAnnounced[currentNumberCount] in ticket.getRow(rowNumber)) {
                crossedNumberCount += 1
            }
            if (currentNumberCount == numbersAnnounced.size - 1 && crossedNumberCount == 5) {
                return true
            }
            if (crossedNumberCount == 5) {
                return false
            }
            currentNumberCount += 1
        }
        return false
    }

    fun fullHouseValidation(
        ticket: TambolaTicket, numbersAnnounced: ArrayList<Int>
    ): Boolean {
        var numberCount = 0
        while (numberCount < numbersAnnounced.size) {
            if (numbersAnnounced[numberCount] in ticket.topRow ||
                numbersAnnounced[numberCount] in ticket.middleRow ||
                numbersAnnounced[numberCount] in ticket.bottomRow
            ) {
                crossedNumberCount += 1
            }
            if (numberCount == numbersAnnounced.size - 1 && crossedNumberCount == 15) {
                return true
            }
            if (crossedNumberCount == 15) {
                return false
            }
            numberCount += 1
        }
        return false
    }

    fun earlyFiveValidation(
        ticket: TambolaTicket, numbersAnnounced: ArrayList<Int>
    ): Boolean {
        var numberCount = 0
        while (numberCount < numbersAnnounced.size) {
            if (numbersAnnounced[numberCount] in ticket.topRow ||
                numbersAnnounced[numberCount] in ticket.middleRow ||
                numbersAnnounced[numberCount] in ticket.bottomRow
            ) {
                crossedNumberCount += 1
            }
            if (numberCount == numbersAnnounced.size - 1 && crossedNumberCount == 5) {
                return true
            }
            if (crossedNumberCount == 5) {
                return false
            }
            numberCount += 1
        }
        return false
    }
}
