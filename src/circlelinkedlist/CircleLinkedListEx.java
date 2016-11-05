package circlelinkedlist;

/**
 * Created by csh9196 on 2016-09-26.
 */
public class CircleLinkedListEx {
    public static void main(String[] args){
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        CircleLinkedList circleNextLinkedList = new CircleLinkedList();

        circleLinkedList.addData(new Node("최선호", "sksms"));
        circleLinkedList.addData(new Node("김남준", "namjune"));
        circleLinkedList.addData(new Node("서보민", "sbm"), 1);

        circleLinkedList.printAll();

        circleLinkedList.addData(new Node("이근혁", "lgh"), 1);

        circleLinkedList.printAll();

        circleLinkedList.removeData(2);

        circleLinkedList.printAll();

        circleNextLinkedList.addData(new Node("이수빈", "leesb"));

        circleLinkedList.concatList(circleLinkedList, circleNextLinkedList);

        circleLinkedList.printAll();

        circleLinkedList.getData(1);
        circleLinkedList.getData(5);
    }
}
