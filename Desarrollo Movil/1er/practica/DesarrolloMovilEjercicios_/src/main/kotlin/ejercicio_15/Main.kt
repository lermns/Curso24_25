package ejercicio_15

import java.lang.Double.parseDouble
import kotlin.math.roundToInt

fun main(){
    var salida:String
    var cantidad = 0.0
    var cont = 0

    do{
        println("cantidad de la venta.")
        salida = readln()//32.3021/ 453.5434/"*"
        if(salida != "*"){
            cantidad += parseDouble(salida)//485.87289
            cont++//2
        }
    }while (salida != "*")

    //forma de redondear a su entero más cercano, en este caso a su decimal ya que esta divido entre 100
    cantidad = (cantidad * 100.0).roundToInt() / 100.0//485.87
    println("Cantidad de ventas $cont \ncantidad total obtenida: $cantidad")
}