package ejercicio_6

fun main(){
    println("""
        ¿Cual es la capital de Colombia?
        a. La Paz
        b. Buenos Aires
        c. La Habana
        d. Bogota
    """.trimIndent())

    do{
        val resp = readln()

        if ("d" != resp){
            println("respuesta incorrecta, vuelva a intentarlo")
        }
    } while ("d"!=resp)

    println("Felicitaciones")
}