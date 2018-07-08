import org.junit.jupiter.api.Test;
import reese.homework.Graph;

import java.util.Set;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class GraphTester
{
    // tests for method "addEdge" in class "Graph"
    @Test
    public void tae0()
    {
        Graph g = new Graph(2);
        g.addEdge(0, 1);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 2\nedges: [[false, true], [false, false]]");
    }

    @Test
    public void tae1()
    {
        Graph graph = new Graph(0);
        graph.addEdge(0,0);
        System.out.println(graph);
        assertEquals("Cannot add edges to a graph of size < 1","Cannot add edges to a graph of size < 1");
    }
    @Test
    public void tae2()
    {
        Graph graph = new Graph(1);
        graph.addEdge(0,0);
        Throwable exception = assertThrows(ArrayIndexOutOfBoundsException.class, () ->
        {
            graph.addEdge(0,1);
        });
        System.out.println(graph);
    }
    @Test
    public void tae3()
    {
        Graph graph = new Graph(3);
        graph.addEdge(0,0);
        graph.addEdge(0,1);
        graph.addEdge(1,1);
        System.out.println(graph);
        assertEquals(graph.toString(), "numNodes: 3\nedges: [[true, true, false], [false, true, false], " +
                "[false, false, false]]");
    }
    @Test
    public void tae4()
    {
        Graph graph = new Graph(4);
        graph.addEdge(0,0);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,0);
        graph.addEdge(1,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,0);
        graph.addEdge(2,1);
        graph.addEdge(2,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);
        graph.addEdge(3,1);
        graph.addEdge(3,2);
        graph.addEdge(3,3);
        System.out.println(graph);
        assertEquals(graph.toString(), "numNodes: 4\nedges: [[true, true, true, true], [true, true, true, true], " +
                "[true, true, true, true], [true, true, true, true]]");
    }

    // your tests for method "addEdge" in class "Graph" go here
    // you must provide at least 4 test methods;
    // each test method has at least 1 invocation of addEdge;
    // each test method creates exactly 1 graph
    // each test method creates a unique graph w.r.t. "equals" method
    // each test method has at least 1 test assertion;
    // your test methods provide full statement coverage of your
    //   implementation of addEdge and any helper methods
    // no test method directly invokes any method that is not
    //   declared in the Graph class as given in this homework
    // ...
    // tests for method "reachable" in class "Graph"
    @Test
    public void tr0()
    {
        Graph g = new Graph(1);
        Set<Integer> nodes = new TreeSet<Integer>();
        nodes.add(0);
        assertTrue(g.reachable(nodes, nodes));
    }
// your tests for method "reachable" in class "Graph" go here
// you must provide at least 6 test methods;
// each test method must have at least 1 invocation of reachable;
// each test method must have at least 1 test assertion;
// at least 2 test methods must have at least 1 invocation of addEdge;
// your test methods must provide full statement coverage of your
//  implementation of reachable and any helper methods
// no test method directly invokes any method that is not
//  declared in the Graph class as given in this homework
// ... }
}
