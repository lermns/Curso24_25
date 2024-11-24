package ejercicio_9

fun main(){
    for (i in 100 downTo 1){
        if(i%2==0 || i%3==0){
            println(i)
        }
    }
}