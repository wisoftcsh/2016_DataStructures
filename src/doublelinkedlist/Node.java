package doublelinkedlist;

/**
 * Created by csh9196 on 2016-09-26.
 */
public class Node {
    private Data data;
    private Node pre;
    private Node next;

    Node() { // 더미노드
        this.data = null;
        this.next = null;
        this.pre = null;
    }

    Node(Data data) {
        this.data = data;
        this.next = null;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public Node getNext() {
        return next;
    }

    public Data getData() {
        return data;
    }
}
