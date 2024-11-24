package ejercicio_27

fun main() {
    println("""
        ----------------------------------------------------------
        Introduce valor numerico + Enter. Valor numero + Enter...
        Cuando quieras terminar, teclea -1 + Enter
        ----------------------------------------------------------
    """.trimIndent())
    var numero:Double
    var cont=0

    do{
        numero = readln().toDouble()

        if (numero!=-1.0){
            cont++
        }else
            break
    }while (true)

    println("Fin, has introducido $cont numeros")
}