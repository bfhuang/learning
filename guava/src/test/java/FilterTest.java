import com.google.common.base.Splitter;
import org.junit.Test;

public class FilterTest {

    @Test
    public void test_splitter() {
        Iterable<String> split1 = Splitter.on(",").trimResults().omitEmptyStrings().split(",a a ,b,,c,");
        for(String s: split1){
            System.out.println(s+"22");
        }
        System.out.println(split1);
        String[] split = ",a a ,b,,c,".split(",");
        System.out.println(split.length);
        for(String s:split){
            System.out.println(s+"11");
        }
    }
}
