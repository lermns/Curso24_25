package ejercicio_13

fun main(){
    println("Introduce un dia de la semana como texto: ")
    val dia = readln()

    when(dia.uppercase()){
        "LUNES","MARTES","MIERCOLES","JUEVES","VIERNES" -> println("Dia laborable")
        "SABADO", "DOMINGO" -> println("Fin de semana")
        else -> println("Error al introducir el día")
    }
}