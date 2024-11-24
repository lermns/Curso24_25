package ejercicio_16

import kotlin.math.roundToInt
import kotlin.system.exitProcess

fun main(){
    println("Dame el primer numero: ")
    var num1 = readln().toDouble()

    println("Dame el segundo numero: ")
    var num2 = readln().toDouble()

    val aux:Double
    if(num1>num2){
        aux=num1
        num1=num2
        num2=aux
    }else if(num1==num2){
        println("los numeros son iguales...!")
        exitProcess(0)
    }

    for (i in 1..10){
        println("$i. " + (((Math.random()*(num2-num1))+num1) * 100.0).roundToInt() / 100.0)//5.7-1.1 = 4.6 = 0.3+1.1 =1.4
    }
}