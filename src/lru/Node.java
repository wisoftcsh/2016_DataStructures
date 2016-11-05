package lru;

public class Node {
    private Object key; // pageNumber
    private Node pre;
    private Node next;
    private int frame;

    public Node() { // 더미노드
        this.key = null;
        this.next = null;
        this.pre = null;
    }

    public Node(Object key) {
        this.key = key;
        this.next = null;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setKey(Object key){ this.key =key;}

    public Node getPre() {
        return pre;
    }

    public Node getNext() {
        return next;
    }

    public void setFrame(int frame){
        this.frame = frame;
    }

    public int getFrame(){
        return frame;
    }

    public Object getKey() {
        return key;
    }

}




