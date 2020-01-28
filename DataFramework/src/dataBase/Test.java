package dataBase;

public class Test {
    public static void main(String[] args) {
        DataBase<Data> b = new DataBase<Data>("G:\\test1.sh");

        System.out.println(b.getData(0));

        for (int i = 0; i < 1000000; i++) {
            b.getData(i).sayHello();
        }
//        b.add(new Data());
//
        b.save("G:\\test1.sh");
    }
}
