package graph;

/**
 * Created by csh9196 on 2016-11-23.
 */
public class GraphEx {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.createGraphNode(new Data('A'));
        graph.createGraphNode(new Data('B'));
        graph.createGraphNode(new Data('C'));
        graph.createGraphNode(new Data('D'));
        graph.createGraphNode(new Data('E'));
        graph.createGraphNode(new Data('F'));
        graph.createGraphNode(new Data('G'));

        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'F');
//        graph.addEdge('A', 'E');
        graph.addEdge('B', 'C');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'B');
        graph.addEdge('D', 'B');
        graph.addEdge('D', 'A');
        graph.addEdge('E', 'C');
        graph.printAll();

        graph.removeEdge('E','C');
        graph.printAll();

        graph.addEdge('E', 'C');
        graph.addEdge('E', 'C');
        graph.printAll();

        System.out.println();
        Depth depth = new Depth(graph); // 여기서 넘겨주는 graph는 복사? 원본? 아마도 원본
        System.out.println("=================== 깊이 ===================");
        depth.search(3);
        System.out.println("============================================");
        graph.initPlag();


        Breadth breadth = new Breadth(graph);
        System.out.println("=================== 넓이 ===================");
        breadth.search(3);
        System.out.println("============================================");
    }
}
