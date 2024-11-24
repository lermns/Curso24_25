package ejercicio_5

fun main(){
    println("Dame un numero: ")
    val valor1 = readln().toDouble()

    if(valor1%2.0==0.0){
        println("El numero $valor1 es divisible entre 2")
    }else
        println("El numero $valor1 no es divisible entre 2")
}

