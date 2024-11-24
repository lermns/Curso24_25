package p1;

import java.util.HashSet;


public class CadenaTextoHashPropio {
    
    private String texto;
    
    public CadenaTextoHashPropio(String texto) {
        this.texto = texto;
    }

    
    @Override
    public int hashCode() {

        System.out.println("\n\nSE LLAMA AL METODO HASHCODE\n");
        
        int codigoHash = 0;
        
        // SE VA OBTENIENDO EL VALOR DE LA LETRA Y SE LE MULTIPLICANDO POR LA POTENCIA
        // DE 2 (2,4,8...) REALIZÁNDOSE FINALMENTE LA SUMA DE TODOS LOS VALORES.
        
        // convertir el String en array de caracteres.
        char[] losCaracteres = texto.toCharArray(); 
        
        for (int contador = 1; contador <= losCaracteres.length; contador++) {
            char    letra       = losCaracteres[contador -1]; // posición 0.
            int     valor       = (int)letra; // convertir char a int (son números).
            int     potencia    = (int)Math.pow(2,contador); // 2, 4, 8 ...
                                    
            System.out.println(letra + " " + valor + " " + potencia);
            codigoHash += valor*potencia; // contador empieza en 1.
            System.out.println("parcial ---> " + codigoHash);
        }
     
        // SI QUEREMOS COMPROBAR COMO FUNCIONA EQUALS, FORZAR EL CODIGO A 0.
        //codigoHash = 0;
        
        System.out.println("\nCODIGO DE HASH OBTENIDO = " + codigoHash + "\n");
        return codigoHash;
    }

    
    @Override
    public boolean equals(Object objeto) {
        System.out.println("\n\nSE LLAMA AL METODO EQUALS\n");
        if(objeto instanceof CadenaTextoHashPropio) {
            // conversión de Object a String.
            CadenaTextoHashPropio cadenaTexto = (CadenaTextoHashPropio)objeto;
            // comparar los String con el método equals del propio String.
            boolean resultado = texto.equals(cadenaTexto.texto);
        
            System.out.println(this + "(this)" + " <-> " + cadenaTexto + "(parametro)");
            System.out.println("EQUALS DICE ... " + resultado);
            return resultado;
        } 
        
        System.out.println("EQUALS DICE FALSE (tipos distintos");
        return false;
    }
    
    
    @Override
    public String toString() {
        return texto;
    }

    
    public static void main(String[] args) {
        
        CadenaTextoHashPropio ct1 = new CadenaTextoHashPropio("HOLA");
        CadenaTextoHashPropio ct2 = new CadenaTextoHashPropio("hola");        
        //CadenaTextoHashPropio ct2 = new CadenaTextoHashPropio("HOLA");
        
        System.out.println("ct1 == ct2 " + (ct1 == ct2));
        
        System.out.println("\n______________________________\n");
        
        HashSet cadenas = new HashSet();
        
        cadenas.add(ct1);
        cadenas.add(ct2);
     
        System.out.println("\n --- ELEMENTOS EN EL HASHSET --- \n");
        System.out.println(cadenas);
        System.out.println("TOTAL ELEMENTOS = " + cadenas.size());
    }    

}