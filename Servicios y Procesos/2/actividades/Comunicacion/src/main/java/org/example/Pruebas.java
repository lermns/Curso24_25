package org.example;

public class Pruebas {
    public static void main(String[] args){
        double num = 123456789;
        int cont=0;
        int cont_mantisa = 0;
        double numDiv = num/10;
        System.out.println(numDiv);

        double num_two = Math.pow(numDiv, 10);

        System.out.println(num_two);

        num_two = Math.pow(num_two, 10);

        System.out.println(num_two);

        while (num_two>10){
            num_two/=10;
            cont_mantisa++;
        }

        while (num>10){
            num/=10;
            cont++;
        }

        System.out.println(num_two + " -> mantisa " + cont_mantisa);

        System.out.println(num + " -> cant " + cont);

        //System.out.println(Math.log10(num)); 8,0
    }
}
