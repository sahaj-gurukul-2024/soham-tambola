package org.example

fun main() {
    val ticket = ArrayList<ArrayList<String>>()

    repeat(3){
        ticket.add(readln().split(',') as ArrayList<String>)
    }
    val numbersAnnounced: ArrayList<String> = readln().split(", ") as ArrayList<String>
    val claim = readln()
    val tambola = Tambola()
    if (tambola.valid(ticket, numbersAnnounced, claim)){
        println("Accepted")
    }
    else{
        println("Rejected")
    }
}
