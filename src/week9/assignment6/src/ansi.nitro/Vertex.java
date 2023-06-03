package week9.assignment6.src.ansi.nitro;

import java.util.HashMap;
import java.util.Map;

/*
Khaimuldin Askar, I really like how you teach and I was happy that you were my teacher.
I think that you will be our teacher in our second course (I like GO), if you stay at the university.
I want to apply for academic mobility, my current gpa is 3.58.
I would be grateful, if you could help me with this.
I screwed up in End-Term Quiz (HELP ME).
Help your future colleague))) (I like GO).
*/

public class Vertex<V> {
    private final V data;
    private Map<Vertex<V>, Double> adjacentVertices; // with weights

    public Vertex(V data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public boolean containsAdjacentVertex(Vertex<V> vertex) {
        return adjacentVertices.containsKey(vertex);
    }

    public double weightTo(Vertex<V> destination) {
//        if (!adjacentVertices.containsKey(destination)) throw new RuntimeException("There is not key");
        if (!adjacentVertices.containsKey(destination)) return Double.MAX_VALUE;

        return adjacentVertices.get(destination);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) obj;
        return data.equals(vertex.data);
    }
}
