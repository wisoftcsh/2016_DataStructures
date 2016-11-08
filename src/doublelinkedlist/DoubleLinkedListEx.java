package doublelinkedlist;

/**
 * Created by csh9196 on 2016-09-26.
 */
public class DoubleLinkedListEx {
    public static void main(String[] args){
        DoubleLinkedList linkedList = new DoubleLinkedList();
        DoubleLinkedList nextLinkedList = new DoubleLinkedList();

        linkedList.addData(new Node(new Data("최선호", "sksms")));
        linkedList.addData(new Node(new Data("김남준", "namjune")));
        linkedList.addData(new Node(new Data("서보민", "sbm")), 1);

        linkedList.printAll();

        linkedList.addData(new Node(new Data("이근혁", "lgh")), 1);

        linkedList.printAll();

        linkedList.removeData(2);

        linkedList.printAll();

        nextLinkedList.addData(new Node(new Data("이수빈", "leesb")));

        linkedList.concatList(linkedList, nextLinkedList);

        linkedList.printAll();

        linkedList.getData(2);
    }
}
