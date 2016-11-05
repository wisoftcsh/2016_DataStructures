package singlylinkedlist;

/**
 * Created by csh9196 on 2016-09-26.
 */
public class Node {
    private Data data;
    private Node pointer;

   public Node() { // 더미노드
        this.data = null;
        this.pointer = null;
    }

    public Node(Data data) {
        this.data = data; // data를 메인에서 만들어서 data를 넘길것
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
