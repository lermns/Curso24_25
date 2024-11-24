package ejercicio_28

fun main() {
    println("escribe una frase: ")
    val frase = readln()
    println("La quieres convertir a:\n1.Mayuscula\n2.Minuscula")
    val cond = readln().toInt()

    when(cond){
        1 -> println(frase.uppercase())
        2 -> println(frase.lowercase())

        /*Este caso default lo hice para agregar un upper y low case intercalado para hacerlo
        * mas interesante, explicacion del uso asSequence
        Uso de asSequence y mapIndex que es similar a Stream y Map de java,
        convertimos en un array de chars, lo convertimos en una secuencia(flujo en java)
        lo volcamos a un mapa indexado que basicamente tiene 2 parametros que 1 de ellos
        guarda la posicion en la que se esta iterando y en el otro parametro se guarda
        el valor de la posicion de este array de chars, en caso que la posicion sea par, esta se
        hace upper y en caso contrario lower, al final se llama al metodo joinToString para unir
        la secuencia de chars en un String para printarlo.
        * */
        else -> println(frase.toCharArray().asSequence()
            .mapIndexed { index, c ->
                if (index % 2 == 0) c.uppercase()
                else c.lowercase()
            }.joinToString(""))
    }
}