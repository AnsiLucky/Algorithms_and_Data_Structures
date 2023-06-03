package week9.assignment6.src.ansi.nitro;

/*
Khaimuldin Askar, I really like how you teach and I was happy that you were my teacher.
I think that you will be our teacher in our second course (I like GO), if you stay at the university.
I want to apply for academic mobility, my current gpa is 3.58.
I would be grateful, if you could help me with this.
I screwed up in End-Term Quiz (HELP ME).
Help your future colleague))) (I like GO).
*/

public class DepthFirstSearch<V> extends Search<V>{
    public DepthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(WeightedGraph<V> graph, V current) {
        marked.add(current);
        count++;
        for (V v : graph.adjacencyList(current))
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
    }
}
