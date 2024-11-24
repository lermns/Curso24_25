package ejercicio_23

fun main(){
    print("Escribe una frase: ")
    val frase = readln()

    println("Palabras sueltas: ")
    frase.split(" ").forEach {x -> println(x)}
    //La lluvia en Sevilla es una maravilla
}