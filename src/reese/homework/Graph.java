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

    //Question 1.1
    //Implementing Graph
    public Graph(int size)
    {
        if(size < 0) throw new NumberFormatException();

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

    //Question 1.2
    //Implementing addEdge
    public void addEdge(int from, int to)
    {
        // postcondition: adds a directed edge "from" -> "to" to this graph
        if(numNodes > 0)
        {
            edges[from][to] = true;
        }
        else
        {
            System.out.println("Cannot add edges to a graph of size < 1");
        }
    }

    //Question 1.3
    //Implementing reachable
    public boolean reachable(Set<Integer> sources, Set<Integer> targets)
    {
        //set a boolean variable to return for method reachable
        boolean allReachable = false;

        if (sources == null || targets == null) throw new IllegalArgumentException();
        // postcondition: returns true if
        //                   (1) "sources" does not contain an illegal node,
//                           (2) "targets" does not contain an illegal node, and
//                           (3) for each node "m" in set "targets", there is some
//                           node "n" in set "sources" such that there is a directed
//                           path that starts at "n" and ends at "m" in "this" or "m == n"; and
//                           false otherwise
        if(checkNodes(sources) == false || checkNodes(targets) == false) throw new IllegalArgumentException();

        //create iterators to iterate through Sets as specified in conditions
        Iterator<Integer> n = sources.iterator();
        Iterator<Integer> m = targets.iterator();

        //returns true if sources and targets are the same nodes
        if(sources.equals(targets)) return true;

        //check to see if there are edges from sources to all targets
        while(m.hasNext())
        {
            while(n.hasNext())
            {
                if(edges[n.next()][m.next()] == true)
                {
                    allReachable = true;
                }
                else
                {
                    allReachable = false;
                    break;
                }
            }

        }

        return allReachable;
    }

    private boolean checkNodes(Set<Integer> nodes)
    {
        Iterator<Integer> nodesIterator = nodes.iterator();
        while (nodesIterator.hasNext())
        {
            if(numNodes < nodesIterator.next())
            {
                return false;
            }
        }
        return true;
    }
}
