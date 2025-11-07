package Grafos;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.BFSShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class RutaMasCortaBFS {

    public static void main(String[] args) {
        System.out.println("--- Búsqueda de Ruta Más Corta (BFS con JGraphT) ---");

        // 2. Crear un grafo simple (no dirigido, no ponderado).
        //    Usamos String para los vértices (ciudades) y DefaultEdge para las aristas (rutas).
        Graph<String, DefaultEdge> redCiudades = new SimpleGraph<>(DefaultEdge.class);

        // 3. Añadir vértices (ciudades)
        redCiudades.addVertex("Cartagena");
        redCiudades.addVertex("Barranquilla");
        redCiudades.addVertex("Santa Marta");
        redCiudades.addVertex("Sincelejo");
        redCiudades.addVertex("Montería");
        redCiudades.addVertex("Valledupar");

        // 4. Añadir aristas (rutas directas)
        redCiudades.addEdge("Cartagena", "Barranquilla");
        redCiudades.addEdge("Barranquilla", "Santa Marta");
        redCiudades.addEdge("Barranquilla", "Sincelejo");
        redCiudades.addEdge("Santa Marta", "Valledupar");
        redCiudades.addEdge("Sincelejo", "Montería");
        redCiudades.addEdge("Montería", "Valledupar"); // Una ruta de conexión

        // 5. Definir el problema: Encontrar la ruta más corta
        String inicio = "Cartagena";
        String fin = "Valledupar";

        System.out.println("\nCalculando la ruta más corta (menos paradas) de: " + inicio + " a " + fin);

        // 6. Usar el algoritmo BFS de JGraphT
        //    JGraphT se encarga de toda la lógica compleja del BFS.
        BFSShortestPath<String, DefaultEdge> bfsAlgoritmo = new BFSShortestPath<>(redCiudades);
        
        // 7. Obtener el resultado
        GraphPath<String, DefaultEdge> ruta = bfsAlgoritmo.getPath(inicio, fin);

        // 8. Imprimir el resultado
        if (ruta == null) {
            System.out.println("No se encontró una ruta entre " + inicio + " y " + fin);
        } else {
            System.out.println("¡Ruta encontrada!");
            // .getVertexList() nos da la lista de ciudades en orden
            System.out.println("La ruta es: " + ruta.getVertexList());
            System.out.println("Número de paradas (saltos): " + (ruta.getLength()));
        }

        // Caso de prueba 2: Ruta directa
        System.out.println("\nCalculando ruta de: Cartagena a Sincelejo...");
        GraphPath<String, DefaultEdge> ruta2 = bfsAlgoritmo.getPath("Cartagena", "Sincelejo");
        System.out.println("La ruta es: " + ruta2.getVertexList()); // Debería ser [Cartagena, Barranquilla, Sincelejo]
    }
}