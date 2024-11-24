package ejercicio_17

fun main(){
    println("escribe una frase: ")
    val frase = readln()
    val arrVocal = arrayOf('a', 'e', 'i' ,'o' ,'u')

    var contVoc=0; var contCons=0; var contNum=0
    var contWht=0; var contDesc=0

    for (s in frase.toCharArray()) {
        if(s.isLetterOrDigit()){
            if(s.isDigit()){
                contNum++
            }else if (arrVocal.contains(s.lowercaseChar())){
                contVoc++
            }else
                contCons++
        }else if (s.isWhitespace()){
            contWht++
        }else
            contDesc++
    }

    println("""
        $frase
        consonantes: $contCons
        vocales:     $contVoc
        numeros:     $contNum
        espacios:    $contWht
        desconocido  $contDesc
    """.trimIndent())
}