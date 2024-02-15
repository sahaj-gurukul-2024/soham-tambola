package org.example

private const val s = "Accepted"

class Tambola(private var ticket: MutableMap<Int, MutableMap<Int, Boolean>>) {


    private val ACCEPTED: String = "Accepted";
    private val REJECTED: String = "Accepted";

    fun getTicket(): MutableMap<Int, MutableMap<Int, Boolean>> {
        return ticket
    }

    fun markNumber(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, number: Int) {
        for ((row, map) in ticket) {
            map[number] = true
        }
    }

    fun checkMarked(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, number: Int): Boolean {
        for ((row, map) in ticket) {
            return map.getOrDefault(number, false)
        }
        return false
    }

    fun validateTopRowClaim(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, lastAnnouncedNumber: Int): Boolean {
        if (!ticket[1]!!.contains(lastAnnouncedNumber)) {
            return false
        }
        ticket[1]?.forEach {
            if (!it.value) {
                return false
            }
        }
        return true
    }

    fun validClaim(claim: String, ticket: MutableMap<Int, MutableMap<Int, Boolean>>, lastAnnouncedNumber: Int): String {
        var valid = false
        if (claim == "Top Row") {
            valid = validateTopRowClaim(ticket, lastAnnouncedNumber)
        }

        return if (valid) ACCEPTED else REJECTED
    }

}


