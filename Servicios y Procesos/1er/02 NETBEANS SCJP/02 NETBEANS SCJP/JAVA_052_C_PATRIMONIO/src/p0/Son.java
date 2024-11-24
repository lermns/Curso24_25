package p0;

public class Son extends Mam{
  private static final int piso=100000;
  private static final int chalet=300000;
  private static final int tierras=700000;
    
  public Son(){
        super(tierras, chalet);
        
        System.out.println("Precio del piso: "+ piso);
  }
    
  public  int calculaPatrimonio(){
     // int q=tierras+chalet+piso;
     // System.out.println("El patrimonio de la hija es de "+q+" €");
      
      
      return tierras+chalet+piso;
  }

}

