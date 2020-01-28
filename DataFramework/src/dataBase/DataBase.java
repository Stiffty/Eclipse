package dataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DataBase<E> {
    private Base<E> b = new Base<>();

    public DataBase(String directory) {

        File f = new File(directory);
        if (f.exists()) {
            load(directory);
        }else {
            save(directory);
        }
    }

    public void load(String directory) {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(directory);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            if (obj instanceof Base) {
                b = (Base) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) try {
                ois.close();
            } catch (IOException e) {
            }
            if (fis != null) try {
                fis.close();
            } catch (IOException e) {
            }
        }
    }

    public void save(String directory) {
        b.save(directory);
    }

    public void add(E data) {
        b.add(data);
    }

    public E getData(int index) {
        if(b.getDataList().size()>0) {
            return b.getDataList().get(index);
        }else {
            return null;
        }
    }

    public void remove(int index){
        b.getDataList().remove(index);
    }

    public void getIndexof(E data){
        b.getDataList().indexOf(data);
    }
}
