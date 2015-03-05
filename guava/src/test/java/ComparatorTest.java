import java.util.Comparator;

/**
 * Created by twer on 1/26/15.
 */
public class ComparatorTest implements Comparator {
    @Override
    public int compare(Object o, Object o2) {
        Person p1 = (Person)o;
        Person p2= (Person)o2;

        return p2.getName().compareTo(p1.getName());
    }
}
