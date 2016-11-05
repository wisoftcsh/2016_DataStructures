package stack;

/**
 * Created by csh9196 on 2016-09-27.
 */
public class Data {
    private int number;

    public Data(int number) {
        this.number = number;
    }

    public String toString() {
        return "" + this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
