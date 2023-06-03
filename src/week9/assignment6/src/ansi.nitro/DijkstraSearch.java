package week9.assignment6.src.ansi.nitro;

import java.util.*;

/*
Khaimuldin Askar, I really like how you teach and I was happy that you were my teacher.
I think that you will be our teacher in our second course (I like GO), if you stay at the university.
I want to apply for academic mobility, my current gpa is 3.58.
I would be grateful, if you could help me with this.
I screwed up in End-Term Quiz (HELP ME).
Help your future colleague))) (I like GO).
*/

public class DijkstraSearch<V> extends Search<V>{
    private Set<V> unsettledNodes;
    private Map<V, Double> distances;
    private WeightedGraph<V> graph;
    private final Vertex<V> sourceVertex;


    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        sourceVertex = graph.getVertex(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (unsettledNodes.size() > 0) {
            V node = getVertexWithMinimumWeight(unsettledNodes);
            marked.add(node);
            unsettledNodes.remove(node);
            for (V target : graph.adjacencyList(node)) {
                if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                    distances.put(target, getShortestDistance(node) + getDistance(node, target));
                    edgeTo.put(target, node);
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private double getDistance(V node, V target) {
        Vertex<V> nodeVertex = graph.getVertex(node);
        Vertex<V> targetVertex = graph.getVertex(target);
        for (Vertex<V> vertex : nodeVertex.getAdjacentVertices().keySet())
            if(vertex.equals(targetVertex))
                return nodeVertex.weightTo(targetVertex);

        return Double.MAX_VALUE;
//        throw new RuntimeException("Not found!");
    }

    private V getVertexWithMinimumWeight(Set<V> vertices) {
        V minimum = null;
        for (V vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(V destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}
