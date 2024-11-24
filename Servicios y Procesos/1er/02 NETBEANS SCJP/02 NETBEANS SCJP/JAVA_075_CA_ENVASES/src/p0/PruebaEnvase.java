package p0;

public class PruebaEnvase {

    public static void main(String[] args) {
        
        Envase[] envases = { new Vaso(), new Botella(),
                            new Tupper(), new Tonel()};
        
        for(Envase envase : envases) {
            System.out.println(envase);
            System.out.println("\n\n");
        }
        
    }
            
}
