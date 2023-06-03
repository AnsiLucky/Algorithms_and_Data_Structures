package week9.assignment6.src.ansi.nitro;

/*
Khaimuldin Askar, I really like how you teach and I was happy that you were my teacher.
I think that you will be our teacher in our second course (I like GO), if you stay at the university.
I want to apply for academic mobility, my current gpa is 3.58.
I would be grateful, if you could help me with this.
I screwed up in End-Term Quiz (HELP ME).
Help your future colleague))) (I like GO).
*/

public class Main {
    public static void main(String[] args) {
        // I think this code shows the work more clearly.
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Aktobe", "Petropavlsk", 1);
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Kostanay", "Aktobe", 3);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Aktobe", 6);
        graph.addEdge("Kostanay", "Shymkent", 2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Kostanay", "Petropavlsk", 1);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, "Almaty");
        outputPath(djk, "Aktobe");

        System.out.println("\n--------------------------------");


        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Aktobe");

        System.out.println("\n--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        outputPath(bfs, "Aktobe");
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}
