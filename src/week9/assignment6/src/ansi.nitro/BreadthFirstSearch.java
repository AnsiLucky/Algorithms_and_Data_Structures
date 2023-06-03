package week9.assignment6.src.ansi.nitro;

import java.util.LinkedList;
import java.util.Queue;

/*
Khaimuldin Askar, I really like how you teach and I was happy that you were my teacher.
I think that you will be our teacher in our second course (I like GO), if you stay at the university.
I want to apply for academic mobility, my current gpa is 3.58.
I would be grateful, if you could help me with this.
I screwed up in End-Term Quiz (HELP ME).
Help your future colleague))) (I like GO).
*/

public class BreadthFirstSearch<V> extends Search<V> {
    BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V current) {
        marked.add(current);
        Queue<V> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            V vertex = queue.remove();
            for (V v : graph.adjacencyList(vertex))
                if (!marked.contains(v)) {
                    marked.add(v);
                    edgeTo.put(v, vertex);
                    queue.add(v);
                }
        }
    }
}
