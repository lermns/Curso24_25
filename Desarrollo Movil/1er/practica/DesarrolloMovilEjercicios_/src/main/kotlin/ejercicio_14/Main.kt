package ejercicio_14

import kotlin.math.roundToInt

fun main(){
    println("ventas realizadas en los ultimos 15 dias ")
    val num = readln().toInt()
    var cantidad = 0.0;

    for (i in 1..num){
        println("cantidad de la venta $i")
        cantidad += readln().toDouble()
    }

    //forma de redondear a su entero más cercano, en este cas a su decimal ya que esta divido entre 100
    cantidad = (cantidad * 100.0).roundToInt() / 100.0
    println("cantidad total de las ventas es $cantidad")
}