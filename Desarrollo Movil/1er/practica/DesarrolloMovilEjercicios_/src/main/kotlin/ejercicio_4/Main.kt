package ejercicio_4

fun main(){
    println("Dame el primer numero: ")
    val valor1 = readln().toDouble()

    println("Dame el segundo numero: ")
    val valor2 = readln().toDouble()

    if(valor1>valor2){
        println("$valor1 es mayor a $valor2")
    }else if(valor1<valor2){
        println("$valor2 es mayor a $valor1")
    }else
        println("$valor2 es igual a $valor1")
}