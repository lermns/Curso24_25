package ejercicio_26

import kotlin.math.sqrt
import kotlin.system.exitProcess

fun main() {
    println("Dame el primer valor: ")
    var valor1 = readln().toInt()

    println("Dame el segundo valor: ")
    var valor2 = readln().toInt()

    val aux:Int

    //en caso que el primer valor sea mayor, invertimos las posiciones para mostrarlo siempre
    //de menor a mayor dentro del rango
    if(valor1>valor2){
        aux=valor1
        valor1=valor2
        valor2=aux
    }else if(valor1==valor2){
        println("los numeros son iguales...!")
        exitProcess(0)
    }

    for (i in valor1..valor2){
        if(esPrimo(i)){
            println(i)
        }
    }
}

fun esPrimo(primoNum:Int):Boolean{
    //en este caso, si el numero pasado llegase a ser 1 este no se considerara primo
    if(primoNum<=1){
        return false
    }
    //sacamos la raiz del numero ya que si no se encuentra primos en la primera mitad se da
    //por sentado que este no lo tiene y asi nos ahorramos iteraciones innecesarias.
    for (i in 2..(sqrt(primoNum.toDouble()).toInt())){
        if(primoNum%i==0){
            return false
        }
    }
    return true
}