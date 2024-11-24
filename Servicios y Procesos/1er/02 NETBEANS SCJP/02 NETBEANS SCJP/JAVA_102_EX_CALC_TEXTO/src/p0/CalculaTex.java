package p0;

public class CalculaTex {

    public static void sumar(String x, String y){
        double miX= convertirTexto(x);
        double miY= convertirTexto(y);

        double res= miX+miY;
        System.out.println("La suma de X="+miX+" + Y="+miY+" es igual a = "+res);
          
    }
    public static void dividir(String x, String y){
        double miX= convertirTexto(x);
        double miY= convertirTexto(y);
        if(miY!=0){    
            double res= miX/miY;
            System.out.println("La división de X="+miX+" / Y="+miY+" es igual a = "+res);
            
        }else{
            System.out.println("El divisor no puede ser 0");
            return;
        }    
    }
    
    public static double convertirTexto(String valor){
        double valorConv=0;
        try{
            valorConv= (double) Double.parseDouble(valor);
            
        }catch(NumberFormatException nfe){
            System.out.println("Error al convertir el dato en un número");
            System.out.println(nfe);
            System.out.println("\n");
            System.exit(0);
        }
        return valorConv;
    }
    
    
}
