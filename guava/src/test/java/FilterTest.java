import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class FilterTest {

    @Test
    public void test_splitter() {
        Iterable<String> split1 = Splitter.on(",").trimResults().omitEmptyStrings().split(",a a ,b,,c,");
        for (String s : split1) {
            System.out.println(s + "22");
        }
        System.out.println(split1);
        String[] split = ",a a ,b,,c,".split(",");
        System.out.println(split.length);
        for (String s : split) {
            System.out.println(s + "11");
        }
    }

    @Test
    public void should() {
        People people = new People();
        ArrayList<Person> persons1 = new ArrayList<Person>();
        persons1.add(new Person("22", 11));
        persons1.add(new Person("11", 11));
        persons1.add(new Person("33", 11));
        persons1.add(new Person("44", 11));
        people.setPeople(persons1);

       Collections.sort(people.getPeople(), new ComparatorTest());

        for (Person person : people.getPeople()) {
            System.out.println(person.getName());
        }

    }
}
