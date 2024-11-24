package ejercicio_10

fun main(){
    println("dame un numero: ")
    var num:Double

    do{
        num = readln().toDouble()
    }while (num<0.0)

    println(num)
}