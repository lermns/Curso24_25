package p0;

public class Mam extends Abu{
   protected int CHALET=0;
    public Mam(int tierras, int chalet){
        super(tierras);
        this.CHALET= chalet;
        System.out.println("Precio del chalet: "+ CHALET);
    }

}
