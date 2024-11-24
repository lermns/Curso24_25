package ejercicio_19

import kotlin.math.pow

fun main(){
    /*
    * Crea una aplicación que pida 2 operandos. A continuación, muestre un menú con las siguientes operaciones:
    1: suma los operandos.
    2: resta los operandos.
    3: multiplica los operandos.
    4: divide los operandos
    5: potencia (1º operando como base y 2º como exponente).
    6: módulo , resto de la división entre operando1 y operando2.
    7: pedir 2 operandos nuevos
    8: Salir
    Según la opción elegida, realizará la operación correspondiente. A continuación mostrará el resultado por consola. El programa terminará al pulsar la opción 8 (Salir).
    * */

    var cond:Int

    println("Dame el primer operando..")
    var operando1:Double = readln().toDouble()
    println("Dame el segundo operando..")
    var operando2:Double = readln().toDouble()

    do{
        println("""
            1: suma los operandos.
            2: resta los operandos.
            3: multiplica los operandos.
            4: divide los operandos
            5: potencia (1º operando como base y 2º como exponente).
            6: módulo , resto de la división entre operando1 y operando2.
            7: pedir 2 operandos nuevos
            8: Salir
        """.trimIndent())
        cond = readln().toInt()

        when(cond){
            1 -> println(operando1+operando2)
            2 -> println(operando1-operando2)
            3 -> println(operando1*operando2)
            4 -> {
                if(operando2!=0.0){
                    println(operando1/operando2)
                }else
                    println("no se puede dividir entre 0")
            }
            5 -> println(operando1.pow(operando2))
            6 -> {
                if(operando2!=0.0){
                    println(operando1%operando2)
                }else
                    println("no se puede dividir entre 0")
            }
            7 -> {
                println("Dame el primer operando..")
                operando1 = readln().toDouble()
                println("Dame el segundo operando..")
                operando2 = readln().toDouble()
            }
            else -> cond = 0
        }
    }while (cond in 1..7)
}