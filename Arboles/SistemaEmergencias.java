package Arboles;

import java.util.PriorityQueue;

public class SistemaEmergencias {

    public static void main(String[] args) {
        System.out.println("--- Sistema de Triage de Emergencias (Simulación con Heap) ---");

        // 1. Creación de la PriorityQueue (Min-Heap).
        //    Almacenará objetos 'Paciente' y los ordenará automáticamente
        //    según el método 'compareTo' que definimos.
        PriorityQueue<Paciente> salaEspera = new PriorityQueue<>();

        // 2. Ingreso de pacientes (los añadimos en desorden)
        //    El método .add() (o .offer()) inserta y reordena el heap (heapify).
        System.out.println("\n[Acción] Llegan pacientes a la sala de espera...");
        salaEspera.add(new Paciente("Ana López", 3));       // Estable
        salaEspera.add(new Paciente("Carlos Vera", 1));      // Crítico
        salaEspera.add(new Paciente("Sofía Ramírez", 2));  // Urgente
        salaEspera.add(new Paciente("Juan Pérez", 1));       // Crítico
        salaEspera.add(new Paciente("Lucía Méndez", 3));    // Estable

        // 3. Atención de pacientes
        //    Usamos .poll() para extraer el elemento con mayor prioridad (la raíz del heap).
        //    El heap se reajusta automáticamente después de cada extracción.
        System.out.println("\n[Acción] Comenzando a atender pacientes por prioridad...");
        
        while (!salaEspera.isEmpty()) {
            // .poll() obtiene y elimina la cabeza de la cola (el paciente más crítico).
            Paciente pacienteAtendido = salaEspera.poll();
            System.out.println("Atendiendo a: " + pacienteAtendido);
        }

        System.out.println("\n--- Todos los pacientes han sido atendidos ---");
    }
}