// Crear la clase Hija, heredera de Madre, en la que sobrescribiremos el método
// que indicaba el valor de la variable x. Se utilizarán las distintas posibilidades
// x, this.x, super.x tanto en el caso de que la propia clase hija defina también
// una variable x, como si no.

// Nota: El método siempre busca allí donde se ha definido. Así, el método dimeX de
// la Madre nos devolverá la x de la madre, no de la hija. Sólo en el caso de que
// sobrescribamos en la hija dicho método y además definamos en ella su propia variable
// x, obtendremos el valor establecido en la hija. Si sobrescribimos pero no definimos
// la x en hija, tanto el método propio como el heredado trabajaran sobre la x de la
// madre, ya que sólo se dispone de una x (x, this.x y super.x actuarían sobre la misma
// variable, la heredada).


package p1;

public class Hija extends Madre {

    // SI DESCOMENTAMOS LA LÍNEA, LA HIJA CREARÁ SU PROPIA VARIABLE x Y POR TANTO
    // EL MÉTODO dimeX() DARÁ (HAY 2 VARIABLES x LA PROPIA Y LA HEREDADA):
    // a. usando x ---------> 2.
    // b. usando this.x ----> 2.
    // c. usando super.x ---> 1.
    
    protected int x = 2;
    
    
    // PROBAR A NO SOBRESCRIBIR EL MÉTODO Y CREAR LA x EN LA HIJA.
    // SE ENTREGARA EL VALOR x=1 YA QUE EL MÉTODO USADO ES EL DE LA MADRE,
    // QUE NO SABE NADA DEL ATRIBUTO x DE LA HIJA.

//    @Override
//    protected void dimeX() {
//        System.out.println(x);      
//        System.out.println(this.x);
//        System.out.println(super.x);        
//    }   

}