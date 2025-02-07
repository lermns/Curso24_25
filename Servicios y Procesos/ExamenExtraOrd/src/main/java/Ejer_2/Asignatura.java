package Ejer_2;

import java.util.Objects;

public class Asignatura {
    private final int codigo;
    private int nota;

    public Asignatura(int codigo, int nota){
        this.codigo = codigo;
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asignatura that)) return false;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Asignatura{" + "codigo=" + codigo +
                ", nota=" + nota +
                '}';
    }
}
