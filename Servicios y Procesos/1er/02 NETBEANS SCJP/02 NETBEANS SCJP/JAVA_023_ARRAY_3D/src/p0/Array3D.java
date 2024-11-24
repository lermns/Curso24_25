// Crear una clase que constituya una array de 3 dimensiones

package p0;

public class Array3D {

    
    public static void main(String[] args) {
        
        // COORDENADAS X-Y-Z:
        
        int[][][] a3D = 
        
        { 
            ///////////////////// 1er SUBARRAY //////////////////////////            
            // coordenada X ... array contenedor de los sub-arrays
            { // coordenada Y ... array sub-contenedor de los sub-sub-arrays
                {1,2,3}, // coordenada Z ... posición del número crudo.
                {4,5,6},
                {7,8,9}
            } ,
            
            ///////////////////// 2do SUBARRAY //////////////////////////            
            
            {
                {11,22,33},
                {44,55,66},
                {77,88,99} // número 99 -- sus coordenadas --> X=1 Y=2 Z=2
            } ,

            ///////////////////// 3er SUBARRAY //////////////////////////            
            
            {
                {111,222,333},
                {444,555,666},
                {777,888,999}
            }         
        };
        
        System.out.println("EL 99 ESTA EN X=1 Y=2 Z=2 ... " + a3D[1][2][2]);
    }
}