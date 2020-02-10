package sample;

import javafx.beans.property.SimpleStringProperty;

public class Testdata{
    private final SimpleStringProperty age;
    private final SimpleStringProperty name;

    Testdata(String age, String name) {
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleStringProperty(age);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}