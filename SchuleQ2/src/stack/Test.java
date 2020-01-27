package stack;

public class Test {

    private int testValue;

    public Test(int testValue) {
        this.testValue = testValue;
    }

    public static void main(String[] args) {
        Stack<Test> s = new Stack<Test>();

        for (int i = 0; i < 1000; i++) s.push(new Test(i));

        while (!s.isEmpty()) {
            System.out.println(s.peek().getTestValue());
            s.pop();
        }
    }

    public int getTestValue() {
        return testValue;
    }

    public void setTestValue(int testValue) {
        this.testValue = testValue;
    }
}
