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

public class Search<V> {
    protected int count;
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected final V source;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V vertex) {
        return marked.contains(vertex);
    }

    public Iterable<V> pathTo(V vertex) {
        if (!hasPathTo(vertex)) return null;
        LinkedList<V> ls = new LinkedList<>();
        for (V i = vertex; i != source; i = edgeTo.get(i))
            ls.push(i);
        ls.push(source);

        return ls;
    }

    public int getCount() {
        return count;
    }
}
