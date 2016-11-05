package circlelinkedlist;

public class CircleLinkedList {
    private int curentCount;
    private Node header;
    private Node preNode;
    private Node delNode;
    private Node tail;

    CircleLinkedList() { // 더미 노드 생성
        this.curentCount = 0;
        header = new Node();
        tail = header;
    }

    public void addData(Node nextNode) {
            tail.setPointer(nextNode);
            nextNode.setPointer(header.getPointer());
            tail = tail.getPointer();
            curentCount++;
    }

    public void addData(Node nextNode, int index) {
        if (index > curentCount) {
            System.out.println("인덱스 오류");
            return;
        }
        preNode = header;
        for (int i = 0; i < index; i++) { // 저장할 노드 위치 전 노드로 이동
            preNode = preNode.getPointer();
        }
        nextNode.setPointer(preNode.getPointer());
        preNode.setPointer(nextNode);
        curentCount++;
    }

    public void removeData(int index) {
        if (index > curentCount) {
            System.out.println("인덱스 오류");
            return;
        }
        if (curentCount == 1) {
            header.setPointer(null);
        } else {
            preNode = header;
            for (int i = 0; i < index; i++) {
                preNode = preNode.getPointer();
            }
            delNode = preNode.getPointer();
            preNode.setPointer(delNode.getPointer());
            // 대상 노드가 가르키는 다음 노드를 이전노드의 포인터에 저장
            delNode.setPointer(null); // 메모리 반환?
            if(index == curentCount -1){
                tail = preNode;
            }
            curentCount--;
        }
    }

    public void concatList(CircleLinkedList list, CircleLinkedList nextList) { //nextList 이름이 좀 부정확.. 어울리는 거 없나요?
        if (list != null && nextList != null) {
            tail.setPointer(nextList.header.getPointer());
            nextList.tail.setPointer(list.header.getPointer());
            curentCount = curentCount + nextList.getCurentCount();
            nextList.header.setPointer(null);
        }
    }

    public void printAll() { // 제너릭으로 바꾸면 삭제해야하는가?
        preNode = header;
        System.out.println("------------------------------------");
        for (int i = 0; i < curentCount; i++) {
            preNode = preNode.getPointer();
            System.out.println(preNode.getData().toString());
        }
    }

    public void getData(int index) { // 제너릭으로 바꾸면 삭제해야하는가?
        if (index > curentCount) {
            System.out.println("인덱스 오류");
            return;
        }
        preNode = header;
        for (int i = 0; i <= index; i++) { // 문제점 : index가 원형이기 때문에 범위를 넘어도 계속 돈다. 따라서 예외처리
            preNode = preNode.getPointer();
        }
        System.out.println("\n검색 결과 --> " + preNode.getData().toString() + "\n"); //Node 클래스의 getData
    }

    public int getCurentCount() {
        return this.curentCount;
    }
}
