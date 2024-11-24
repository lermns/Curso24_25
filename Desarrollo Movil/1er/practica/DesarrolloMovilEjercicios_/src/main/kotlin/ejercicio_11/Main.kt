package ejercicio_11

fun main(){
    val contra = "cualquiera"

    println("escribe la contraseña")
    var verifi:String

    for (i in 1 .. 3){
        verifi = readln()
        if (verifi == contra){
            println("Enhorabuena, acertaste")
            break;
        }else
            println("Has fallado. Te quedan ${3-i} intentos")
    }
}