public class Main {
    public static void main(String[] args) {
        String[][][] arryString = new String[4][4][4];

        for (int i = 0; i < arryString.length; i++) {
            for (int j = 0; j < arryString[i].length; j++) {
                for (int k = 0; k < arryString[i][j].length; k++) {
                    int rand = (int)(Math.random()*26)+5;
                    arryString[i][j][k] = devolverString(rand);
                    System.out.println(rand);
                }
            }
        }

        for (String[][] s: arryString){
            for (String[] a : s){
                for (String t: a){
                    System.out.print(t + "--");
                }
                System.out.println();
            }
            System.out.println();
        }


    }
    private static String devolverString(int cant){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <cant ; i++) {
            char num = (char)(int)((Math.random()*26)+65);
            char numAlt = (char)(int)((Math.random()*2)+1)==1?num:Character.toLowerCase(num);
            s.append(numAlt);
        }

        return s.toString();
    }
}
