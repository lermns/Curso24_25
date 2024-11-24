package p2;

public class ArraysSumaParesAndres {

    public static void main(String[] args) {
        int arrayPares []= {10,20,30,40,50};
        int arraySumatorio []= new int[arrayPares.length];
        
        
        for (int i = 0; i < arraySumatorio.length; i++) {
            int suma=0;
        
            for (int j = 0; j <= i; j++) {
                suma+=arrayPares[j];
                
                
            }
            System.out.println("suma "+ i + " "+suma);
            arraySumatorio[i]=suma;
        }
        
        for (int i = 0; i < arraySumatorio.length; i++) {
            System.out.println("posición "+ i+" del array "+ arraySumatorio[i]);
        }
    
        
    }
    
    
}
