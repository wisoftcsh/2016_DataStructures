package arraylist;

public class Node {
    private String name;
    private String position;

    Node() {
    }

    Node(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String toString() {
        return "직책 : " + this.position + "   |   " + "성명 : " + this.name;
    }
}