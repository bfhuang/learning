package beanWrapper;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class PersonTest {

    @Test
    public void spring_bean_wrapper_test() {
        Person person = new Person();
        BeanWrapper personWrapper = new BeanWrapperImpl(person);

        personWrapper.setPropertyValue("name", "name2");
        personWrapper.setPropertyValue("age", "13");

        System.out.println(person);
//        System.out.println(person.getName());
//        System.out.println(person.getAge());

        BeanWrapper wrapper = new BeanWrapperImpl(Person.class);
        wrapper.setPropertyValue("name", "name1");
        wrapper.setPropertyValue("age", 11);

        System.out.println(wrapper.getWrappedInstance());
    }
}
