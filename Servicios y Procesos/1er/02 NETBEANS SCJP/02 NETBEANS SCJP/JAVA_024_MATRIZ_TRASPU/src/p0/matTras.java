package p0;
//ordenar 

//1 2 3      4 2 7 
//4 5 6  <-- 1 3 6 
//7 8 9      5 9 8
public class matTras {

    public static void main(String[] args) {
        int[][] mat1={ {1,2,3} , {4,5,6} };
        int[][] matT=new int[mat1[0].length][mat1.length];
        System.out.println("Mi matriz:");
        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat1[i].length;j++){
                matT[j][i]=mat1[i][j];
                
            }
            
        }
        System.out.println("Saco mi matriz:");
        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat1[i].length;j++){
                System.out.print(" "+mat1[i][j]);
            }    
            System.out.println(" ");
        }
        System.out.println("--con un for-------------");

        
        for(int i=0;i<matT.length;i++){
            for(int j=0;j<matT[j].length;j++){
              //System.out.println(" ");
                System.out.print(matT[i][j]+" ");
            }    
            System.out.println("");
        }
  
        System.out.println("--con for each-------------------");
         for (int[] array : matT) {
            for(int valor : array) {
                System.out.print(valor + " ");
            }
            System.out.println("");
        }     
         
        System.out.println("matriz inversa:"); 
        System.out.println(""+ matT[0][0]+" "+ matT[0][1] );
        System.out.println(""+ matT[1][0]+" "+ matT[1][1] );
        System.out.println(""+ matT[2][0]+" "+ matT[2][1] );
    }
}
