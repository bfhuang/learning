package beanWrapper;

/**
 * Created by twer on 8/6/14.
 */
public class Dog {
    private String name;

    public Dog(String name){
        this.name = name;
    }

    public Dog(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
