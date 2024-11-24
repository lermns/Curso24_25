package ejercicio_22

fun main(){
    var bandera=true
    var frase:String
    var fraseTotal = ""

    do{
        println("Introduce un texto, cadena vacia para terminar.")
        frase = readln()

        if (frase.isNotEmpty()){
            fraseTotal += "$frase\n\t"
        }else
            bandera=false
    }while (bandera)

    println("""
    Cadena resultante:
    -----------------------------------------------
    $fraseTotal
    """)
}

/*
Esta es la primera frase
Esta es la segunda frase
Si no te funcion vas a suspender
Lo siguiente va a ser una cadena vacia
* */