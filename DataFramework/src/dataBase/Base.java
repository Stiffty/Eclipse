package dataBase;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Base<E> implements Serializable{
    private List<E> dataList = new ArrayList<>();

    public void add(E data){
        dataList.add(data);
    }

    public void save(String directory){
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(directory);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos!= null) try{oos.close();} catch (IOException e){};
            if (fos!= null) try{fos.close();} catch (IOException e){};
        }
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
    }
}
