package dataBase;

import java.io.Serializable;

public class Data implements Serializable {
private int i;
private String name;
private int alter;

    public Data(int i, String name, int alter) {
        this.i = i;
        this.name = name;
        this.alter = alter;
    }

    public void sayHello(){
        System.out.println("Hello");
    }
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }
}
