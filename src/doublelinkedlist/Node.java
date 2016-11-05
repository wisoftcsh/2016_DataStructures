package doublelinkedlist;

/**
 * Created by csh9196 on 2016-09-26.
 */
public class Node {
    private Data data;
    private Node prePointer;
    private Node nextPointer;

    Node() { // 더미노드
        this.data = null;
        this.nextPointer = null;
        this.prePointer = null;
    }

    Node(String name, String eMail) {
        this.data = new Data(name, eMail);
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
