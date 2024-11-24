// Crear una clase que simule un campo de dimensiones cuadradas (mismas filas
// que columnas) que procederemos a minar y posteriormente a limpiar, a través
// de los elementos de una colección de tipo ArrayList. Se dispone de métodos
// para inicializar el campo ('-'), minar el campo ('*') y desactivar las minas
// ('X'). El sistema nos permitirá establecer las dimensiones y el total de minas
// a colocar. Los valores no pueden ser negativos, y en el caso de las minas, no
// se podrá designar un número superior al de los elementos que constituyen el
// propio campo. Hacer uso de los métodos add, set, contains, indexOf ... etc, de
// la clase ArrayList para realizar el ejercicio. 

// Nota: Se puede utilizar marca de género <Character> para establecer en tiempo
// de compilación, el tipo de elementos del ArrayList.


package p0;

import java.util.ArrayList;

public class CampoMinas {

    private ArrayList<Character> elementos; // marca de género Character.
   
    
    // Se diseña el campo para que tenga forma cuadrada. Número filas == columnas.
    public CampoMinas(int filasColumnas, int cuantasMinas) {
        elementos = new ArrayList<Character>();
        crearCampo(filasColumnas);
        visualizarCampo();
        System.out.println("\n\n");
        minarCampo(cuantasMinas);
        visualizarCampo();
        System.out.println("\n\n");
    }
    
    
    private void crearCampo(int filasColumnas) { // crear matriz cuadrada.
        
        if(filasColumnas <= 0) {
            System.out.println("INTRODUCE 1 O SUPERIOR PARA LAS DIMENSIONES DEL CAMPO");
            System.exit(0);
        }
        
        for (int i = 0; i < Math.pow(filasColumnas,2); i++) { // matriz cuadrada vista como una línea.
            elementos.add('-'); // rellenarla con los caracteres - que simboliza "sin mina".
            // nos quedará algo como [-,-,-,-,-,-,-,-,-] para 3x3.
        }
    }
    
    
    private void minarCampo(int cuantasMinas) { // podemos minar por completo el campo.
        if(cuantasMinas<0 || cuantasMinas>elementos.size()) {
            System.out.println("ERROR, SOLO PUEDES COLOCAR 0 .. " + elementos.size() + " MINAS");
            System.exit(0);
        }
        
        for (int i = 0; i < cuantasMinas; /*NADA*/) {
            int posicionAleatoriaMina = (int)(Math.random()*elementos.size());
            if('*' == elementos.get(posicionAleatoriaMina)) {
                // LA POSICIÓN YA TIENE UNA MINA. REPETIR COLOCACIÓN.
                continue;
            }
            
            // un * simboliza una mina. Cambiar un - por un * para colocar mina.
            elementos.set(posicionAleatoriaMina, '*');
            i++; // incrementar aquí, no en el for (evitamos el repetir una mina).
        }        
    } 

    
    public void visualizarCampo() {
        
        int saltoLinea = (int)Math.sqrt(elementos.size()); // cuántos elementos para salto de línea.
        
        for (int i = 0; i < elementos.size(); i++) {
            if(i!=0 && i%saltoLinea == 0) {
                System.out.println(""); // meter salto de línea.                
            }
            
            System.out.print(elementos.get(i) + " ");

            // obtendremos algo cómo (para una 3x3):
            // - - -
            // - * -
            // - - *            
        }
    }    
    
    
    public void desactivarCampo() {
        
        while(elementos.contains('*')) { // seguir hasta que no quede ninguna mina.
            int posicionMina = elementos.indexOf('*');
            System.out.println("AVISO: SE DETECTA UNA MINA EN LA POSICION" + " DE INDICE " + posicionMina);
            elementos.set(posicionMina, 'X'); // un X es mina desactivada
        }
        
        
        
        
        System.out.println("\nEL CAMPO ESTA LIMPIO DE MINAS\n");
        
        visualizarCampo();    
        
        System.out.println("\n\n");
        
        
        //También se puede hacer con un for    (--------------------------------------------------------------------hecho para comprobación de cómo realizarlo con un bucle FOR)
        for(int i=1;i<elementos.size();i++){
            char a = elementos.get(i);
            if (a=='X'){
                elementos.set(i, '/');
            }
        
        }
        visualizarCampo();    
    }
    
    
    public static void main(String[] args) {
        
        CampoMinas cm = new CampoMinas(5,8); // 5x5, con 8 minas.
        
        cm.desactivarCampo();
    }

}