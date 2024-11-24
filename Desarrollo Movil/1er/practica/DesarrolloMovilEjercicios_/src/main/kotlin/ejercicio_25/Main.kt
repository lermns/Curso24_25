package ejercicio_25

import kotlin.math.sqrt

fun main() {
    println("Dame un numero para verificar si es primo: ")
    val numero = readln().toInt()
    println("el numero $numero es primo?: ${esPrimo(numero)}")

}
fun esPrimo(primoNum:Int):Boolean{
    if(primoNum<=1){
        return false
    }

    for (i in 2..(sqrt(primoNum.toDouble()).toInt())){
        if(primoNum%i==0){
            return false
        }
    }
    return true
}