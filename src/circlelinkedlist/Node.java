package circlelinkedlist;

/**
 * Created by csh9196 on 2016-09-26.
 */
public class Node {
    private Data data;
    private Node pointer;

    Node() { // 더미노드
        this.data = null;
        this.pointer = null;
    }

    Node(String name, String eMail) {
        this.data = new Data(name, eMail);
        this.pointer = null;
    }

    public void setPointer(Node pointer) {
        this.pointer = pointer;
    }

    public Data getData() {
        return data;
    }

    public Node getPointer() {
        return pointer;
    }

}
