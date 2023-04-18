import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Graph g = createGraph();
    }

    /**
     *
     * @return
     */
    public static Graph createGraph() {
        Graph graph = new Graph();

        // Add vertices / nodes
        graph.addVertex("Esbjerg");
        graph.addVertex("Sønderborg");

        // Add edges between vertices
        graph.addEdge("Esbjerg", "Sønderborg");

        return graph;
    }
}