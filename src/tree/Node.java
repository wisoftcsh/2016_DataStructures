package tree;

public class Node {
    private Data data;
    private Node leftNode;
    private Node rightNode;

   public Node() { // 더미노드
        this.data = null;
        this.leftNode = null;
    }

    public Node(Data data) {
        this.data = data; // data를 메인에서 만들어서 data를 넘길것
        this.leftNode = null;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public Data getData() {
        return data;
    }
}
