package ejercicios.ejercicio_1

fun main() {
    println("escribe una frase: ")
    val frase = readln()
    println("La quieres convertir a:\n1.Mayuscula\n2.Minuscula")
    val cond = readln().toInt()

    when(cond){
        1 -> println(frase.uppercase())
        2 -> println(frase.lowercase())
        else -> println(frase.toCharArray().asSequence()
            .mapIndexed { index, c ->
                if (index % 2 == 0) c.uppercase()
                else c.lowercase()
            }.joinToString(""))
    }
}
