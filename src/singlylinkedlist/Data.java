package singlylinkedlist;

/**
 * Created by csh9196 on 2016-09-27.
 */
public class Data {
    private String name;
    private String eMail;

    public Data(String name, String eMail){
        this.name = name;
        this.eMail = eMail;
    }

    public String toString() {
        return "이름 : " + this.name + "   |   " + "eMail : " + this.eMail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void seteEmail(String eMail) {
        this.eMail = eMail;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.eMail;
    }
}
