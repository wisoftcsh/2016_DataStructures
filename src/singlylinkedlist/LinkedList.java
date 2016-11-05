package singlylinkedlist;

public class LinkedList {
    private int currentCount;
    private Node header;
    private Node preNode;
    private Node delNode;
    private Node tail;

    LinkedList() { // 더미 노드 생성
        this.currentCount = 0;
        header = new Node();
        tail = header;
    }

    public void addData(Node nextNode) { //인덱스 정보가 없으면 기존 리스트 뒤에 붙인다.
            tail.setPointer(nextNode);
            tail = tail.getPointer();
            currentCount++;
    }

    public void addData(Node nextNode, int index) {
        if (index > currentCount) {
            System.out.println("인덱스 정보가 잘못됐습니다.");
            return;
        }
        preNode = header;
        for (int i = 0; i < index; i++) { // 저장할 노드 위치 이전 노드로 이동
            preNode = preNode.getPointer();
        }
        nextNode.setPointer(preNode.getPointer());
        preNode.setPointer(nextNode);
        currentCount++;
    }

    public void removeData(int index) {
        if (index > currentCount) {
            System.out.println("인덱스 정보가 잘못됐습니다.");
            return;
        }
        preNode = header;
        for (int i = 0; i < index; i++) {
            preNode = preNode.getPointer();
        }
        delNode = preNode.getPointer();
        preNode.setPointer(delNode.getPointer());
        // 대상 노드가 가르키는 다음 노드를 이전노드의 포인터에 저장
        delNode.setPointer(null); // 메모리 반환? null을 입력하면 진짜 null?
        if(index == currentCount -1){
            tail = preNode;
        }
        currentCount--;
    }

    public void concatList(LinkedList list, LinkedList nextList) { //nextList 이름이 좀 부정확.. 어울리는 거 없나요?
        if (list != null && nextList != null) {
            tail.setPointer(nextList.header.getPointer());
            currentCount = currentCount + nextList.getCurentCount();
            nextList.header.setPointer(null);
        }
    }

    public void printAll() { // 제너릭으로 바꾸면 삭제해야하는가?
        preNode = header;
        System.out.println("------------------------------------");
        for (int i = 0; i < currentCount; i++) {
            preNode = preNode.getPointer();
            System.out.println(preNode.getData().toString());
        } // while문 안에서 null이면 멈추는 방법도 있음.
    }

    //질문 ) deleteList 함수의 경우.. 자바에서 가비지컬렉션을 이용하는 방법은????

    public void getData(int index) {
        preNode = header;
        for (int i = 0; i <= index; i++) {
            preNode = preNode.getPointer();
        }
        System.out.println("\n검색 결과 --> " + preNode.getData().toString() + "\n"); //Node 클래스의 getData
    }

    public int getCurentCount() {
        return this.currentCount;
    }
}
