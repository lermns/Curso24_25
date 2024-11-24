// Crear una clase que muestre una lista con los meses del año, elija 1 aleatoriamente,
// indicándose el número de mes y un comentario para la estación a la que pertenece.
// Utilizar bucle for-each y un bloque switch.

// n-1 ... numero de mes en el array.

// mar(2)-abr(3)-may(4)     ... PRIMAVERA
// jun(5)-jul(6)-ago(7)     ... VERANO
// sep(8)-oct(9)-nov(10)    ... OTOÑO
// dic(11)-ene(0)-feb(1)    ... INVIERNO

//ES LA ESTACION DE PRIMAVERA ... EL CAMPO SE LLENA DE FLORES
//ES LA ESTACION DE VERANO ... LA PLAYA SE LLENA DE GENTE
//ES LA ESTACION DE OTOÑO ... EL PARQUE SE LLENA DE HOJAS
//ES LA ESTACION DE INVIERNO ... EL SUELO SE LLENA DE NIEVE


package p1;

public class MesesCalendario {

    public static void main(String[] args) {
        
        String[] meses = {  "ENERO", "FEBRERO", "MARZO",
                            "ABRIL", "MAYO", "JUNIO",
                            "JULIO", "AGOSTO", "SEPTIEMBRE",
                            "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
        };
        

        
        for(String mes : meses) {
            System.out.println("---> " + mes);
        }
        
        System.out.println("\n______________________________\n");
        
        int aleatorio = (int)(Math.random()*meses.length); // [0 .. 11]
        System.out.println("EL MES NUMERO ... " + (aleatorio+1) + " ES ... " + meses[aleatorio]);
        
        System.out.println("\n");
        
        switch(aleatorio) { // aprovechamos el efecto FALLTHROUGH.
            case 2:
            case 3:
            case 4:
                System.out.println("ES LA ESTACION DE PRIMAVERA ... EL CAMPO SE LLENA DE FLORES");
                break;

            case 5:
            case 6:
            case 7:
                System.out.println("ES LA ESTACION DE VERANO ... LA PLAYA SE LLENA DE GENTE");
                break;
                
            case 8:
            case 9:
            case 10:
                System.out.println("ES LA ESTACION DE OTOÑO ... EL PARQUE SE LLENA DE HOJAS");
                break;
                
            case 11:
            case 0:
            case 1:
                System.out.println("ES LA ESTACION DE INVIERNO ... EL SUELO SE LLENA DE NIEVE");
                break;
                
            default:
                System.out.println("MES INCORRECTO ... " + aleatorio);                
        }
    }    
}