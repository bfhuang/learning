package beanWrapper;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class PersonTest {

    @Test
    public void spring_bean_wrapper_test() {
//      the parameter of bean wrapper can be a instance
        Person person = new Person("name",0);
        BeanWrapper personWrapper = new BeanWrapperImpl(person);

        personWrapper.setPropertyValue("name", "name2");
        personWrapper.setPropertyValue("age", "13");

        System.out.println(person);

//      the parameter of bean wrapper could be a class type but the class should have a non parameter
//      constructor
        BeanWrapper wrapper = new BeanWrapperImpl(Person.class);
        wrapper.setPropertyValue("name", "name1");
        wrapper.setPropertyValue("age", 11);
        wrapper.setPropertyValue("dog", new Dog("dogName"));

        System.out.println(wrapper.getWrappedInstance());
    }
}
