package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val ticket = ArrayList<ArrayList<String>>()
    var numbersAnnounced = ArrayList<String>()
    var numbersGained = 0
    repeat(3){
        ticket.add(readln().split(',') as ArrayList<String>)
    }
    numbersAnnounced = readln().split(", ") as ArrayList<String>
    val claim = readln()
    var flag=false

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
    if (flag){
        println("Accepted")
    }
    else{
        println("Rejected")
    }
}