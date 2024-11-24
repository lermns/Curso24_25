// Crear una clase que utilice los 8 tipos de Wrappers disponibles, comprobando
// el funcionamiento del autoBoxing, el autoUnBoxing, las distintas posibilidades
// de crearlos (constructor, valueOf, ...), así como la capacidad de comportarse
// como fábricas de conversión de tipos (salvo Boolean y Character).


package p0;

public class Envoltorios {

    public static void main(String[] args) {
        
        
       Float f = Float.valueOf("1.0F");
       f= Float.parseFloat("1.0F");
       System.out.println("f: "+f);
       
       
       
        
        
        // AUTOBOXING.
        
        // boolean:
        Boolean w1 = true;
        
        // byte:
        Byte w2 = 1;
        
        // short:
        Short w3 = 2;
        
        // char:
        Character w41 = 'a';
        Character w42 = 67;
        
        //int:
        Integer w5 = 3;
        
        //long:
        Long w6 = 4L; // requiere el sufijo porque si no, lo toma como int con lo
                      // que sería necesario autopromocionar a long(primitivo) y  
                      // luego hacer autoBoxing a Long(Wrapper), lo cuál no está
                      // permitido. NO PUEDEN DARSE LAS 2 OPERACIONES SIMULTÁNEAMENTE.
        
        // float:
        Float w7 = 5F; // requiere sufijo (lo toma como int).
        
        // double:
        Double w8 = 6D; // requiere sufijo (lo toma como int).
                
        // DISTINTAS FORMAS DE CREAR EL WRAPPER:
        Integer wrapperInteger1 = new Integer(5);
        Integer wrapperInteger2 = new Integer("5");        
        Integer wrapperInteger3 = Integer.valueOf(5);
        Integer wrapperInteger4 = Integer.valueOf("5");
        Integer wrapperInteger5 = 5; // AUTOBOXING.
        Integer wrapperInteger6 = Integer.parseInt("6"); // Character no tiene parseChar("").
        
        System.out.println("---> " + wrapperInteger1);
        System.out.println("---> " + wrapperInteger2); 
        System.out.println("---> " + wrapperInteger3); 
        System.out.println("---> " + wrapperInteger4); 
        System.out.println("---> " + wrapperInteger5);
        System.out.println("---> " + wrapperInteger6);
               
        int valor5 = wrapperInteger5;
        System.out.println("valor5 = " + valor5);
        
        Byte wrapperByte5 = 5; // AUTOBOXING.
        byte byte5 = wrapperByte5; // AUTOUNBOXING.
        
        // FÁBRICAS DE CONVERSIÓN:
        System.out.println("5 en int ... " + wrapperInteger5.intValue());
        System.out.println("5 en byte ... " + wrapperInteger5.byteValue());
        System.out.println("5 en double ... " + wrapperInteger5.doubleValue());
        
        Integer wrapperValor1000 = 1000;
        byte byte1000 = wrapperValor1000.byteValue(); // pérdida de precisión.
        System.out.println("byte1000 = " + byte1000);
        
        Character wrapperCharacter = new Character('a');
        System.out.println("---> " + wrapperCharacter);
       
        // PUEDEN UTILIZARSE LETRAS MAYÚSCULAS Y MINÚSCULAS. 
        Boolean wrapperBoolean = Boolean.parseBoolean("TruE");
        System.out.println("---> " + wrapperBoolean);
    }
}