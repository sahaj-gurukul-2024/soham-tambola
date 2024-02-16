package org.example

fun main() {
    val tambola = Tambola()

    val ticket = TambolaTicket(
        arrayOf(4, 16, 48, 63, 76),
        arrayOf(7, 23, 38, 52, 80),
        arrayOf(9, 25, 56, 64, 83),
    )

    val numbersAnnounced = arrayListOf(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83)

    val claim = "FullHouse"

    if (tambola.validateClaim(ticket, numbersAnnounced, claim)){
        println("Accepted")
    }
    else{
        println("Rejected")
    }
}
