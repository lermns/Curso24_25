// Crear la clase abstracta Billete como punto de inicio de la jerarquía de
// clase. Se dispondrá de los atributos pais, moneda y valor para a partir de
// ellos sobrescribir los métodos equals (Deep-Comparation) y hashCode(suma de
// los valores de todos los atributos). La definición de los métodos establecida
// aquí se propaga a las clases hijas (equals, hashCode y toString son públicos).


package billetes;

public abstract class Billete {

    protected String pais;
    protected String moneda;
    protected Integer valor;

    @Override
    public int hashCode() {
        int codigoHash = pais.hashCode() - moneda.hashCode() + valor.hashCode();
        System.out.println(imprimir() + " ---> CODIGO HASH ... " + codigoHash + "\n");
        return codigoHash;
    }
        
    @Override
    public boolean equals(Object objeto) {
        System.out.println("EN METODO EQUALS");
        
        if(objeto instanceof Billete) {
            Billete billeteExterno = (Billete)objeto;
            
            if(     pais.equals(billeteExterno.pais) &&
                    moneda.equals(billeteExterno.moneda) &&
                    valor.intValue() == billeteExterno.valor.intValue() // sacar el valor.
              ) {
                System.out.println("*** REPETIDO. NO VOY AÑADIR EL BILLETE ... " +
                    objeto.getClass().getSimpleName().toUpperCase() + "\n\n");
                
                return true;
            }

            System.out.println("SE AÑADE EL BILLETE ... " +
                    objeto.getClass().getSimpleName().toUpperCase());
        }        
        
        return false;        
    }
   
    private String imprimir() {
        return pais + "-" + moneda + "-" + valor;
    }
    
    @Override
    public String toString() {
        return imprimir();
    }

}