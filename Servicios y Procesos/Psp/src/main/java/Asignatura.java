import java.util.Objects;

public class Asignatura {
    private int cod;
    private int nota;

    public Asignatura(int cod, int nota){
        this.cod = cod;
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return cod == that.cod;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cod);
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "cod=" + cod +
                ", nota=" + nota +
                '}';
    }
}
