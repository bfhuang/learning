import java.util.ArrayList;
import java.util.List;

public class InputHandler {
	public static List<Integer> getNumbers(String input) {
		ArrayList numbers = new ArrayList();
		for(int i = 0; i<input.length();i++){
			numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
		}
		return numbers;
	}
}
