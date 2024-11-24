package ejercicio_24

fun main() {
    val listNumeros = ArrayList<Int>()
    var num:Int

    do {
        println("Introduce un numero: ")
        num = readln().toInt()
        if (num != -1) {
            listNumeros.add(num)
        }
    } while (num != -1)

    println("""
        El menor es: ${listNumeros.min()}
        El mayor es: ${listNumeros.max()}
        La suma es: ${listNumeros.sum()}
        La suma de los positivos es: ${listNumeros.filter {it>0}.sum()}
        La suma de los negativos es: ${listNumeros.filter {it<0}.sum()} 
    """.trimIndent())
}