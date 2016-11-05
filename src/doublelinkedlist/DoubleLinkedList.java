package doublelinkedlist;

public class DoubleLinkedList {
    private int curentCount;
    private Node header;
    private Node preNode;
    private Node nextNode;
    private Node delNode;
    private Node tail;

    DoubleLinkedList() { // 더미 노드 생성
        this.curentCount = 0;
        header = new Node();
        tail = header;
    }

    public void addData(Node nextNode) {
        tail.setNextPointer(nextNode);
        nextNode.setPrePointer(tail);
        nextNode.setNextPointer(header);
        header.setPrePointer(nextNode);
        tail = tail.getNextPointer();
        curentCount++;
    }

    public void addData(Node nextNode, int index) {
        if (index > curentCount) {
            System.out.println("인덱스 정보가 잘못됐습니다.");
            return;
        }
        preNode = header;
        for (int i = 0; i < index; i++) { // 저장할 노드 위치 이전 노드로 이동
            preNode = preNode.getNextPointer();
        }

        nextNode.setNextPointer(preNode.getNextPointer());
        nextNode.setPrePointer(preNode.getNextPointer().getPrePointer());
        preNode.getNextPointer().setPrePointer(nextNode);
        preNode.setNextPointer(nextNode);
        curentCount++;
    }

    public void removeData(int index) {
        if (index > curentCount) {
            System.out.println("인덱스 정보가 잘못됐습니다.");
            return;
        }
        preNode = header;
        for (int i = 0; i < index; i++) {
            preNode = preNode.getNextPointer();
        }
        delNode = preNode.getNextPointer();
        preNode.setNextPointer(delNode.getNextPointer());
        delNode.getNextPointer().setPrePointer(preNode);
        // 대상 노드가 가르키는 다음 노드를 이전노드의 포인터에 저장
        delNode.setNextPointer(null); // 메모리 반환? null을 입력하면 진짜 null?
        delNode.setPrePointer(null);
        if(index == curentCount -1){
            tail = preNode;
        }
        curentCount--;
    }

    public void concatList(DoubleLinkedList list, DoubleLinkedList nextList) { //nextList 이름이 좀 부정확.. 어울리는 거 없나요?
        if (list != null && nextList != null) {
            tail.setNextPointer(nextList.header.getNextPointer());
            nextList.header.getNextPointer().setPrePointer(tail);
            curentCount = curentCount + nextList.getCurentCount();
            nextList.header.setNextPointer(null);
            nextList.header.setPrePointer(null);
        }
    }

    public void printAll() { // 제너릭으로 바꾸면 삭제해야하는가?
        preNode = header;
        System.out.println("------------------------------------");
        for (int i = 0; i < curentCount; i++) {
            preNode = preNode.getNextPointer();
            System.out.println(preNode.getData().toString());
        }
    }

    //질문 ) deleteList 함수의 경우.. 자바에서 가비지컬렉션을 이용하는 방법은????

    public void getData(int index) {
        preNode = header;
        for (int i = 0; i <= index; i++) {
            preNode = preNode.getNextPointer();
        }
        System.out.println("\n검색 결과 --> " + preNode.getData().toString() + "\n"); //Node 클래스의 getData
    }

    public int getCurentCount() {
        return this.curentCount;
    }
}
