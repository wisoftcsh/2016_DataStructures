package graph;

/**
 * Created by csh9196 on 2016-11-23.
 */
public class GraphEx {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.createGraphNode(new Data('A'));
        graph.createGraphNode(new Data('B'));
        graph.createGraphNode(new Data('C'));
        graph.createGraphNode(new Data('D'));
        graph.createGraphNode(new Data('E'));

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('A', 'E');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'D');
        graph.addEdge('D', 'E');
        graph.addEdge('E', 'A');
        graph.printAll();

        graph.removeEdge('E','A');
        graph.printAll();

        graph.addEdge('E', 'A');
        graph.addEdge('E', 'A');
        graph.printAll();
    }
}
