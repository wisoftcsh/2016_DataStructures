package lru;

public class LruStack {
    Node overlapNode; // 중복 스택
    Node stack;
    Node bottom;
    Node top; // currentCount-1 and tail 과 같은 의미

    Frame frame;
    int address; // 배열의 인덱스
    boolean checkFlag = false; // 2가지 true 를 구분하기위한 변수

    LruStack(Frame frame) {
        this.frame = frame; // 프레임 생성
        stack = new Node();
        top = stack;
        bottom = stack;
        stack.setPre(null);
    }

    public void push(Node newStack, Data data) {
        overlapNode = null; // 초기화
        boolean check;
        check = checking(newStack.getKey(), data); // pageNumber check
        if (frame.isFull()) {
            if (check) {
                if(checkFlag){
                    setTop();
                }else{
                    notEqualData(newStack, data);
                }
            } else {
                fullFrameSetData(newStack, data);
            }
        } else {
            if (check) {
                if (checkFlag) {
                    setTop();
                } else {
                    notEqualData(newStack, data);
                }
            } else {
                normalSetData(newStack, data);
            }
        }
    }

    public boolean checking(Object key, Data data) { //중복확인
        Node flag; //임시 변수
        flag = stack;
        while (flag.getNext() != null) {
            flag = flag.getNext();
            if (flag.getKey().equals(key)) {
                if (data.equals(frame.getFrameData(flag.getFrame()))) { // 새로들어온 데이터와 기존 데이터의 비교
                    //데이터와 키가 모두 동일함으로 기존의 노드를 Top으로 변경
                    checkFlag = true;
                    overlapNode = flag;
                    return true;
                } else {
                    //키는 동일하나 데이터가 불일치, 따라서 기존 노드 삭제 후, 새 노드 top 에 추가
                    checkFlag = false;
                    overlapNode = flag;
                    return true;
                }
            }
        }
        return false;
    }

    public void setTop(){
        if(overlapNode == top){
            System.out.println("이미 Top 에 위치한 중복 노드입니다.");
            return;
        }
        overlapNode.getPre().setNext(overlapNode.getNext());
        overlapNode.getNext().setPre(overlapNode.getPre());
        overlapNode.setNext(null); // null 인 이유는 원형 리스트가 아닌 마지막 노드라는 것을 위해
        overlapNode.setPre(top);
        top.setNext(overlapNode);
        top = overlapNode;
        bottom = stack.getNext();
        System.out.println("Key : " + overlapNode.getKey() + ", Data : " + frame.getFrameArray()[overlapNode.getFrame()] + " ---> Key 와 Data 모두 일치, Top 설정");
    }

    public void notEqualData(Node newStack, Data data){
        overlapNode.getPre().setNext(overlapNode.getNext());
        overlapNode.getNext().setPre(overlapNode.getPre());
        overlapNode.setNext(null); // null 인 이유는 원형 리스트가 아닌 마지막 노드라는 것을 위해
        overlapNode.setPre(top);
        top.setNext(overlapNode);
        top = overlapNode;
        bottom = stack.getNext();
        //굳이 기존 노드를 삭제 할 이유가 없다.
        overlapNode.setKey(newStack.getKey()); //스택 key 설정
        address = overlapNode.getFrame(); // 주소 (인덱스)
        frame.addFrame(data, address); //프레임에 기존 데이터 대신 새로운 데이터 저장
        System.out.println("Key : " + overlapNode.getKey() + ", Data : " + frame.getFrameArray()[overlapNode.getFrame()] + " ---> Key 는 일치하나 Data 불일치, Data 저장");
    }

    public void normalSetData(Node newStack, Data data){
        top.setNext(newStack);
        newStack.setPre(top);
        newStack.setNext(null);
        top = newStack;
        bottom = stack.getNext();
        address = frame.findNullIndex(); // 주소 (인덱스)
        frame.addFrame(data, address); //프레임에 데이터 저장
        newStack.setFrame(address); //스택 프레임 포인터 설정 : 인덱스 번호 저장
        System.out.println("Key : " + newStack.getKey() + ", Data : " + frame.getFrameArray()[newStack.getFrame()] + " ---> push");
    }

    public void fullFrameSetData(Node newStack, Data data){
        top.setNext(newStack);
        newStack.setPre(top);
        newStack.setNext(null);
        top = newStack;
        newStack.setFrame(bottom.getFrame());
        frame.addFrame(data, newStack.getFrame());
        stack.setNext(bottom.getNext());
        bottom.getNext().setPre(stack);
        bottom.setPre(null);
        bottom.setNext(null);
        bottom = stack.getNext();
        System.out.println("Key : " + newStack.getKey() + ", Data : " + frame.getFrameArray()[newStack.getFrame()] + " ---> push");
    }

    public void printStack(){
        frame.printFrame();
        Node tmpTop;
        tmpTop = top;
        System.out.println("====== Stack =======");
        while(tmpTop != stack){
            System.out.println(tmpTop.getKey());
            tmpTop = tmpTop.getPre();
        }
        System.out.println("====================");
    }
}
