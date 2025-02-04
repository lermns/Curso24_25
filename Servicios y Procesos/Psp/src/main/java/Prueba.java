import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prueba {
    public static void main(String[] args) {
        int cod, nota, num;
        Scanner scInt = new Scanner(System.in);

        System.out.println("dame el expediente: ");
        num = scInt.nextInt();
        if ((int)(Math.log10(Math.abs(num))+1) != 8){
            System.err.println("valor no valido");
            System.exit(0);
        }

        Set<Asignatura> listAsign = new HashSet<>();
        for (int i = 0; i < 6; ) {
            System.out.println("dame el cod: ");
            cod = scInt.nextInt();
            System.out.println("dame la nota: ");
            nota = scInt.nextInt();

            Asignatura s = new Asignatura(cod, nota);

            if (!listAsign.add(s)) {
                System.out.println("esta asignatura ya existe, intentelo de nuevo...");
                continue;
            }
            i++;
        }

        double media = listAsign.stream().mapToDouble(Asignatura::getNota).sum()/listAsign.size();

        System.out.println("nota media: " + media);

        listAsign.forEach(System.out::println);
    }
}
/*
12345678
12345679
12345671
12345672
12345673
12345674
*/