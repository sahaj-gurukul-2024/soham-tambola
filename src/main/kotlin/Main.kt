package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class Tambola(){
    private var numbersGained = 0

    fun rowValidation(ticket:ArrayList<ArrayList<String>>, numbersAnnounced:ArrayList<String>,
                 row_number:Int): Boolean {

        var numberCount = 0
        while (numberCount<numbersAnnounced.size){
            if (numbersAnnounced[numberCount] in ticket[row_number]){
                numbersGained+=1
            }
            if (numberCount==numbersAnnounced.size-1 && numbersGained==5){
                return true
            }
            if (numbersGained==5){
                return false
            }
            numberCount+=1

        }
        return false
    }

    fun earlyNumberValidation(ticket:ArrayList<ArrayList<String>>, numbersAnnounced:ArrayList<String>,
                              number:Int):Boolean{
        var numberCount = 0
        while (numberCount<numbersAnnounced.size){
            if (numbersAnnounced[numberCount] in ticket[0] || numbersAnnounced[numberCount] in ticket[1] ||
                numbersAnnounced[numberCount] in ticket[2]){
                numbersGained+=1
            }
            if (numberCount==numbersAnnounced.size-1 && numbersGained==number){
                return true
            }
            if (numbersGained==number){
                return false
            }
            numberCount+=1

        }
        return false
    }


}
fun main() {
//    val ticket = ArrayList<ArrayList<String>>()
//    var numbersAnnounced = ArrayList<String>()
//
//    repeat(3){
//        ticket.add(readln().split(',') as ArrayList<String>)
//    }
//    numbersAnnounced = readln().split(", ") as ArrayList<String>
//    val claim = readln()
//    val tambola = Tambola()
//    if (tambola.validate(ticket, numbersAnnounced, claim)){
//        println("Accepted")
//    }
//    else{
//        println("Rejected")
//    }
}