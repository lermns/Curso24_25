package billetes;

public class PapelMoneda {
    protected String pais;
    protected String moneda;
    protected Integer valor;

    @Override
    public int hashCode() {
        int hash = this.pais.hashCode()+this.moneda.hashCode()+this.valor.hashCode();
        System.out.println("HASH: --> "+hash);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("EQUALS: -->");
        if (obj == null) {
            System.out.println("SE AÑADE:(cond 1)");
            return false;
        }
        if (getClass() != obj.getClass()) {
            System.out.println("SE AÑADE:(2)");
            return false;
        }
        final PapelMoneda other = (PapelMoneda) obj;
        if ((this.pais == null) ? (other.pais != null) : !this.pais.equals(other.pais)) {
            System.out.println("SE AÑADE:(3)");
            return false;
        }
        if ((this.moneda == null) ? (other.moneda != null) : !this.moneda.equals(other.moneda)) {
            System.out.println("SE AÑADE:(4)");
            return false;
        }
        System.out.println("NO SE AÑADE:");
        return true;
    }
    
     private String imprimir() {
        return pais + "-" + moneda + "-" + valor;
    }
     @Override
     public String toString(){
         return imprimir();
     }
}