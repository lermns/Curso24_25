package p0;

public class Fulano {
    private static final int QUIERO = 600000;
    
    public static void meCaso(int qtd){
        if (qtd<QUIERO){
            System.out.println("\n\nNO SE CASA PORQUE LA HIJA ES DE FAMILIA POBRE");
        }else{
            System.out.println("\n\nDA UN BRAGUETAZO!!!!!!!!!!!");
        }
    
    }
    
    public static void main(String[] args) {
        int patrimonio=0;
        System.out.println("Soy un fulano que\n\n");
        Son s=new Son();
        patrimonio=s.calculaPatrimonio();
        System.out.println("Viendo que el patrimonio es: "+patrimonio+"\n");
        meCaso(patrimonio);
        
    }
    
    
    
}
