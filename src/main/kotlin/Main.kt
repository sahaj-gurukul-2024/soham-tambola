package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class Tambola(){
    private var flag=false
    private var numbersGained = 0

    fun validate(ticket:ArrayList<ArrayList<String>>, numbersAnnounced:ArrayList<String>,
                 claim:String): Boolean {
        if (claim=="Top Row"){
            var numberCount = 0
            while (numberCount<numbersAnnounced.size){
                if (numbersAnnounced[numberCount] in ticket[0]){
                    numbersGained+=1
                }
                if (numberCount==numbersAnnounced.size-1 && numbersGained==5){
                    flag=true
                    break
                }
                if (numbersGained==5){
                    break
                }
                numberCount+=1

            }
        }
        else if (claim=="Bottom Row"){
            var numberCount = 0
            while (numberCount<numbersAnnounced.size){
                if (numbersAnnounced[numberCount] in ticket[2]){
                    numbersGained+=1
                }
                if (numberCount==numbersAnnounced.size-1 && numbersGained==5){
                    flag=true
                    break
                }
                if (numbersGained==5){
                    break
                }
                numberCount+=1

            }
        }
        else if (claim=="Early Five"){
            var numberCount = 0
            while (numberCount<numbersAnnounced.size){
                if (numbersAnnounced[numberCount] in ticket[0] || numbersAnnounced[numberCount] in ticket[1]
                    || numbersAnnounced[numberCount] in ticket[2]){
                    numbersGained+=1
                }
                if (numberCount==numbersAnnounced.size-1 && numbersGained==5){
                    flag=true
                    break
                }
                if (numbersGained==5){
                    break
                }
                numberCount+=1

            }
        }
        return flag
    }


}
fun main() {
    val ticket = ArrayList<ArrayList<String>>()
    var numbersAnnounced = ArrayList<String>()

    repeat(3){
        ticket.add(readln().split(',') as ArrayList<String>)
    }
    numbersAnnounced = readln().split(", ") as ArrayList<String>
    val claim = readln()
    val tambola = Tambola()
    if (tambola.validate(ticket, numbersAnnounced, claim)){
        println("Accepted")
    }
    else{
        println("Rejected")
    }
}