package arraylist;

import java.lang.reflect.Array;

public class ArrayList<T> {
    int currentCount; // 현재 자료 수와 새로운 자료를 대입할 포인터 역활
    T[] wisoftPositionList;

    ArrayList(Class<T[]> c,int maxCount) {
        this.currentCount = 0;
        this.wisoftPositionList = c.cast(Array.newInstance(c.getComponentType(), maxCount));
    }

    //배열의 공간 판별
    public boolean isfull() {
        if (wisoftPositionList.length == currentCount) {
            return true;
        } else if (currentCount < wisoftPositionList.length) {
            return false;
        }
        return true;
    }

    public int searchName(String name) { // 빠른 탐색 방법? 이진탐색은 정렬되어있을 때만 가능, 이름이 중복일 경우엔?
        for (int i = 0; i < currentCount; i++) {
            if (wisoftPositionList[i] instanceof Node) { // ArrayList 안에 들어있는 객체가 Node인지 판별
                if (((Node) wisoftPositionList[i]).getName().equals(name)) { //함수 호출 문제...
                    return i;
                }
            }
        }
        System.out.println("탐색 결과가 없습니다.");
        return -1;
    }

    public void addData(T node) {
        if (!isfull()) {
            wisoftPositionList[currentCount++] = node;
        } else {
            System.out.println("배열에 공간이 없습니다.");
        }
    }

    public void addData(T node, int index) {
        if (currentCount < index) {
            System.out.println("인덱스 위치가 잘못지정됨");
            return;
        }
        if (!isfull()) {
            for (int i = currentCount; i > index; i--) { // 자료의 이동
                wisoftPositionList[i] = wisoftPositionList[i - 1];
            }
            wisoftPositionList[index] = node;
            currentCount++;
        } else {
            System.out.println("배열에 공간이 없습니다.");
        }
    }

    public void removeNameData(String name) { //이름으로 삭제하기
        int index = searchName(name);
        if (index != -1) {
            removeData(index);
        }
    }

    public void removeData(int index) {
        if (currentCount <= index) {
            System.out.println("인덱스 위치가 잘못지정됨");
            return;
        }
        System.out.println(wisoftPositionList[index] + "  --> 목록 삭제");
        for (int i = index; i < currentCount - 1; i++) {
            wisoftPositionList[i] = wisoftPositionList[i + 1];
        }
        wisoftPositionList[currentCount - 1] = null;
        currentCount--;
    }

    public void getData(int index) {
        System.out.println("========= 연구원 정보 =========");
        System.out.println(wisoftPositionList[index]);
        System.out.println("===============================");
    }

    public void printListAll() {
        if (currentCount != -1) {
            System.out.println("========= 연구원 정보 =========");
            for (T i : wisoftPositionList) {
                if (i != null) {
                    System.out.println(i);
                }
            }
            System.out.println("===============================");
        } else {
            System.out.println("배열이 없습니다.");
        }
    }

    public void deleteList() {
        wisoftPositionList = null;
        currentCount = -1;
    }
}
