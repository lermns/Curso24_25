package Prueba;

import java.util.Arrays;

public class Prueba {
    public static void main(String[] args) {
        String s1 = "awdawa1.docx";
        String s2 = "awdawa2.doc";
        String s3 = "awdawa3.doct";

        String[] strArry = s3.split("\\.");
        String s = strArry[strArry.length-1];
        System.out.println(s);
        System.out.println(s.contains("do"));
        Arrays.asList(s3.split("(\\.do.*)")).forEach(System.out::println);
    }
}
