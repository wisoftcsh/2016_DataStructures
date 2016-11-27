package graph;

/**
 * Created by csh9196 on 2016-11-22.
 */
public class LinkedList {
    private Node header;
    private Node preNode;
    private Node delNode;
    private Node tail;
    private boolean flag = false;

    LinkedList(Data data) { // 더미 노드 생성 ( = 그래프 노드)
        header = new Node(data);
        tail = header;
    }

    public void addData(Node nextNode) {
        check(nextNode.getData());
        if(flag == false) {
            tail.setNextNode(nextNode);
            tail = tail.getNextNode();
        }
    }

    public void removeData(Data data) {
        preNode = header;
        if(preNode.getNextNode() == null){
            return;
        }
        while(preNode.getNextNode() != null){
            if(preNode.getNextNode().getData().toString().equals(data.toString())){ //toString 이 있고 없고의 차이???????
                delNode = preNode.getNextNode();
                preNode.setNextNode(delNode.getNextNode());
                delNode.setNextNode(null);

                Node tailNode = header; // tail 재설정 부분 줄일수 없나?
                while (tailNode.getNextNode() != null){
                    tailNode = tailNode.getNextNode();
                }
                tail = tailNode;
                break;
            }
            preNode = preNode.getNextNode();
        }
    }

    public Node getHeaderNode(){
        return header;
    }

    public void check(Data data){
        Node tmpNode = header;
        if(tmpNode.getNextNode() == null){  // 맨처음 넣을때
            flag = false;
        }
        while(tmpNode.getNextNode() != null){
            if(tmpNode.getNextNode().getData().toString().equals(data.toString())){
                System.out.println("중복되는 간선입니다.");
                flag = true;
                return;
            }
            tmpNode = tmpNode.getNextNode();
        }
        flag = false;
    }

    public void printAll(){
        Node printNode = header;
        while(printNode.getNextNode() != null){
            printNode = printNode.getNextNode();
            System.out.print(printNode.getData() + " ");
        }
    }
}
