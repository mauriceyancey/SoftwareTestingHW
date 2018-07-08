package reese.homework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Graph
{
    private int numNodes; // number of nodes in the graph
    private boolean[][] edges;

    // edges[i][j] is true if and only if there is an edge from node i to node j
    // class invariant: fields "edges" is non-null;
    //                  "edges" is a square matrix;
    //                  numNodes is number of rows in "edges"
    public Graph(int size)
    {
        numNodes = size;
        edges = new boolean[size][size];

//        Initialize edges to FALSE so that it is non-null
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                edges[i][j] = false;
            }
        }
    }

    public String toString()
    {
        return "numNodes: " + numNodes + "\n" + "edges: " + Arrays.deepToString(edges);
    }

    public boolean equals(Object o)
    {
        if (o.getClass() != Graph.class) return false;
        return toString().equals(o.toString());
    }

    public void addEdge(int from, int to)
    {
        // postcondition: adds a directed edge "from" -> "to" to this graph
        edges[from][to] = true;
    }

    public boolean reachable(Set<Integer> sources, Set<Integer> targets)
    {
        if (sources == null || targets == null) throw new IllegalArgumentException();
        // postcondition: returns true if
        //                   (1) "sources" does not contain an illegal node,
//                           (2) "targets" does not contain an illegal node, and
//                           (3) for each node "m" in set "targets", there is some
//                           node "n" in set "sources" such that there is a directed
//                           path that starts at "n" and ends at "m" in "this"; and
//                           false otherwise
        


        return false;
    }

    private boolean checkNodes(Set<Integer> nodes)
    {
        Iterator<Integer> iterator = nodes.iterator();
        while (iterator.hasNext())
        {
            if(numNodes < iterator.next())
            {
                return false;
            }
        }
        return true;
    }
}
