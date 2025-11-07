package Arboles;
// 1. Implementamos 'Comparable' para que la PriorityQueue sepa cómo ordenar.
//    Comparará pacientes basado en su 'prioridad'.
public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private int prioridad; // 1: Crítico, 2: Urgente, 3: Estable

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        String estado = switch (prioridad) {
            case 1 -> "Crítico";
            case 2 -> "Urgente";
            case 3 -> "Estable";
            default -> "Desconocido";
        };
        return "Paciente [Nombre: " + nombre + ", Prioridad: " + prioridad + " (" + estado + ")]";
    }

    // 2. Este es el método clave.
    //    Compara 'this.prioridad' con 'otro.prioridad'.
    //    Esto hace que la PriorityQueue funcione como un Min-Heap (ordena de menor a mayor).
    @Override
    public int compareTo(Paciente otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }
}