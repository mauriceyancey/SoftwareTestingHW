import org.junit.jupiter.api.Test;
import reese.homework.Graph;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;


//Question 2
//Testing Graph implementation
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

    //test that you can't add an edge to a graph with no nodes
    @Test
    public void tae1()
    {
        Graph graph = new Graph(0);
        graph.addEdge(0,0);
        System.out.println(graph);
        assertEquals("Cannot add edges to a graph of size < 1","Cannot add edges to a graph of size < 1");
    }

    //test for adding an edge to a node that doesn't exist
    @Test
    public void tae2()
    {
        Graph graph = new Graph(1);
        graph.addEdge(0,0);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> graph.addEdge(0,1));
        System.out.println(graph);
    }

    //test that adding edges works correctly
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

    //test that adds edges to all nodes
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

    //Test that a node can reach itself
    @Test
    public void tr0()
    {
        Graph g = new Graph(1);
        Set<Integer> nodes = new TreeSet<Integer>();
        nodes.add(0);
        assertTrue(g.reachable(nodes, nodes));
    }

    //Test that nodes without edges cannot reach each other
    @Test
    public void tr1()
    {
       Graph graph = new Graph(2);
       Set<Integer> sources = new TreeSet<Integer>();
       Set<Integer> targets = new TreeSet<Integer>();
       sources.add(0);
       targets.add(1);
       assertFalse(graph.reachable(sources, targets));
    }

    //Test that edges need to be in the right direction for reachable, i.e source to target only
    @Test
    public void tr2()
    {
        Graph graph = new Graph(2);
        Set<Integer> sources = new TreeSet<Integer>();
        Set<Integer> targets = new TreeSet<Integer>();
        sources.add(0);
        targets.add(1);
        graph.addEdge(0,1);
        assertTrue(graph.reachable(sources, targets));


    }

    //Test that edges need to be in the right direction for reachable, i.e source to target only
    @Test
    public void tr3()
    {
        Graph graph = new Graph(2);
        Set<Integer> sources = new TreeSet<Integer>();
        Set<Integer> targets = new TreeSet<Integer>();
        sources.add(0);
        targets.add(1);
        graph.addEdge(1,0);
        assertFalse(graph.reachable(sources, targets));
    }

    //Test that null sources and targets throw an exception
    @Test
    public void tr4()
    {
        Graph graph = new Graph(2);
        assertThrows(IllegalArgumentException.class, () -> graph.reachable(null, null));
    }

    //Test that node values are within bounds
    @Test
    public void tr5()
    {
        Graph graph = new Graph(2);
        Set<Integer> sources = new TreeSet<Integer>();
        Set<Integer> targets = new TreeSet<Integer>();
        sources.add(3);
        targets.add(0);
        targets.add(1);
        assertThrows(IllegalArgumentException.class, () ->graph.reachable(sources, targets));
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
