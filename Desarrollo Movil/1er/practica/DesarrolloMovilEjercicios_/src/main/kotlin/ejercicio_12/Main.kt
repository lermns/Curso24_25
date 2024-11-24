package ejercicio_12

fun main(){
    println("Introduce un mes (con numero del 1 al 12): ")
    val numMes = readln().toInt()
    val meses = arrayOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")

    when (numMes){
        1,3,5,7,8,10,12 -> println("El mes de ${meses[numMes-1]} tiene 31 dias")
        2 -> println("El mes de ${meses[numMes-1]} tiene 29 dias")
        4,6,9,11 -> println("El mes de ${meses[numMes-1]} tiene 30 dias")
        else -> println("Error en el numero introducido.")
    }
}