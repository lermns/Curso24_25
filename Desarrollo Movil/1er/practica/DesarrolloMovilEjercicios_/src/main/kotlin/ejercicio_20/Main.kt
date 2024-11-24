package ejercicio_20

import kotlin.system.exitProcess

fun main(){
    println("Inserta un numero entero mayor que 1: ")
    val numero:Int = readln().toInt()
    var numSum = 0

    if(numero<=1){
        println("el numero debe ser mayor a 1")
        exitProcess(0)
    }

    for (i in 1..numero){
        numSum+=i
    }

    println("\nLa suma desde 1 hasta $numero es $numSum")
}