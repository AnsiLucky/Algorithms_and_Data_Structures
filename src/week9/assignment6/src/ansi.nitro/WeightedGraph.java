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

public class WeightedGraph<V> {
    private final boolean undirected;
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this.undirected = true;
        vertices = new HashMap<>();
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        vertices = new HashMap<>();
    }

    public void addVertex(V vertex) {
        vertices.put(vertex, new Vertex<V>(vertex));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);
        if (!hasVertex(dest))
            addVertex(dest);
        if (hasEdge(source, dest) || source.equals(dest))
            return;
        vertices.get(source).addAdjacentVertex(vertices.get(dest),weight);

        if (undirected)
            vertices.get(dest).addAdjacentVertex(vertices.get(source),weight);
    }

    public int getVerticesCount() {
        return vertices.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> v : vertices.values()) {
            count += v.getAdjacentVertices().size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public Iterable<V> adjacencyList(V vertex) {
        if (!hasVertex(vertex)) return null;
        List<V> adjacencyList = new LinkedList<>();
        for (Vertex<V> v : vertices.get(vertex).getAdjacentVertices().keySet())
            adjacencyList.add(v.getData());

        return adjacencyList;
    }

    public Iterable<Vertex<V>> getEdges(V vertex) {
        if (!hasVertex(vertex)) return null;

        return vertices.get(vertex).getAdjacentVertices().keySet();
    }

    public Iterable<V> getVertices() {
        return vertices.keySet();
    }

    public Vertex<V> getVertex (V vertex) {
        return vertices.get(vertex);
    }

    public boolean hasVertex(V v) {
        return vertices.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!(hasVertex(source) && hasVertex(dest))) return false;
        return vertices.get(source).getAdjacentVertices().containsKey(dest);
    }
}
