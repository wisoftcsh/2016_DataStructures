package stack;

public class Node {
    private Data data;
    private Node prePointer;
    private Node nextPointer;

    public Node() { // 더미노드
        this.data = null;
        this.nextPointer = null;
        this.prePointer = null;
    }

    public Node(Data data) {
        this.data = data;
        this.nextPointer = null;
    }

    public void setPrePointer(Node prePointer) {
        this.prePointer = prePointer;
    }

    public void setNextPointer(Node nextPointer) {
        this.nextPointer = nextPointer;
    }

    public Node getPrePointer() {
        return prePointer;
    }

    public Node getNextPointer() {
        return nextPointer;
    }

    public Data getData() {
        return data;
    }

}
