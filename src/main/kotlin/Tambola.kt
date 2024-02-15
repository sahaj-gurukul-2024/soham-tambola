package org.example

class Tambola(private var ticket: MutableMap<Int, MutableMap<Int, Boolean>>) {

    fun getTicket(): MutableMap<Int, MutableMap<Int, Boolean>> {
        return ticket
    }

    fun markNumber(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, number: Int) {
        for ((row, map) in ticket) {
            map.put(number, true)
        }
    }


    fun checkMarked(ticket: MutableMap<Int, MutableMap<Int, Boolean>>, number: Int): Boolean {
        for ((row, map) in ticket) {
            return map.getOrDefault(number, false)
        }
        return false
    }

}


