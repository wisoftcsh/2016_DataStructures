package graph;

/**
 * Created by csh9196 on 2016-11-22.
 */
public class Node {
    private Data data;
    private Node nextNode;

    public Node(Data data) {
        this.data = data;
        this.nextNode = null;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Data getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }
}
