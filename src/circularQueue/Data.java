package circularQueue;

public class Data {
    private Object data;

    Data() {
    }

    Data(Object data) {
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String toString(){
        return "" + data;
    }

    public boolean equals(Object data){
        return this.data.toString().equals(data.toString());
    }
}
