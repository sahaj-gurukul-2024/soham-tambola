package org.example

class Tambola(private var ticket: MutableMap<Int, MutableMap<Int, Boolean>>) {

    fun getTicket(): MutableMap<Int, MutableMap<Int, Boolean>> {
        return ticket
    }

    fun markNumber(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, number: Int) {
        for ((row, map) in ticket) {
            if (map.containsKey(number)) {
                map.replace(number, true)
            }
        }
    }

    fun checkMarked(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, number: Int): Boolean {
        for ((row, map) in ticket) {
            if (map.containsKey(number)) {
                return map.getOrDefault(number, false)
            }
        }
        return false
    }

    fun validateTopRowClaim(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, lastAnnouncedNumber: Int): Boolean {
        val topRow = ticket[1]
        if (!topRow!!.containsKey(lastAnnouncedNumber) || topRow.get(lastAnnouncedNumber) == false) {
            return false
        }
        topRow.forEach {
            if (!it.value) {
                return false
            }
        }
        return true
    }

    private fun validBottomRowClaim(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, lastAnnouncedNumber: Int): Boolean {
        val bottomRow = ticket.get(3)
        if (!bottomRow!!.containsKey(lastAnnouncedNumber) || bottomRow.get(lastAnnouncedNumber) == false) {
            return false
        }
        bottomRow.forEach {
            if (!it.value) {
                return false
            }
        }
        return true
    }

    fun earlyFive(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, lastAnnouncedNumber: Int): Boolean {
        var countMarked = 0
        var lastAnnouncedNumberPresent = false
        for ((row, map) in ticket) {
            if (map.containsKey(lastAnnouncedNumber)) {
                lastAnnouncedNumberPresent = true
            }
            map.forEach {entry ->
                if (entry.value) {
                    countMarked++
                }
            }
        }
        if (countMarked == 5 && lastAnnouncedNumberPresent) {
            return true
        }
        return false
    }

    fun validClaim(claim: String, ticket: MutableMap<Int, MutableMap<Int, Boolean>>, lastAnnouncedNumber: Int): String {
        var valid = false
        if (claim == "Top Row") {
            valid = validateTopRowClaim(ticket, lastAnnouncedNumber)
        } else if (claim == "Bottom Row") {
            valid = validBottomRowClaim(ticket, lastAnnouncedNumber)
        } else if (claim == "Early Five") {
            valid = earlyFive(ticket, lastAnnouncedNumber)
        }
        if (valid) {
            return "Accepted"
        }
        return "Rejected"
    }


}


