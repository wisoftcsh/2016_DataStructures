package arraylist;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<Node> arrayList = new ArrayList<>(Node[].class, 10);

        arrayList.addData(new Node("최선호", "학부"));
        arrayList.addData(new Node("김남준", "학부"));
        arrayList.addData(new Node("이근혁", "학부"));
        arrayList.addData(new Node("서보민", "학부"));

        arrayList.getData(2);

        arrayList.addData(new Node("박현주", "교수"), 0);
        arrayList.addData(new Node("전현식", "박사"), 1);

        arrayList.printListAll();

        arrayList.removeNameData("이근혁");
        arrayList.removeData(3);

        arrayList.printListAll();

        arrayList.deleteList();

        arrayList.printListAll();
    }
}
