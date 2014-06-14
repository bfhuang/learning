package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
	private static List<String> splitBys = Arrays.asList(",","\n");

	public static int add(String input) {
		if(input.equalsIgnoreCase("")){
			return 0;
		}
		if(input.matches("[0-9]+")){
			return Integer.parseInt(input);
		}


		return doAdd(doSplitBys(splitBys, new ArrayList<String>(Arrays.asList(input))));
	}

	private static List<String> doSplitBys(List<String> splitBys, List<String> inputs) {

		for(String splitBy:splitBys) {
		   inputs = doSplitBy(splitBy, inputs);
		}
		return inputs;
	}

	private static List<String> doSplitBy(String splitBy, List<String> inputs) {
		List<String> results = new ArrayList<String>();
		for(String input : inputs) {
			String[] split = input.split(splitBy);
			results.addAll(Arrays.asList(split));
		}
		return results;
	}

	private static int doAdd(List<String> splitInputs) {
		int sum = 0;
		for(String s : splitInputs){
			sum+=Integer.parseInt(s);
		}
		return sum;
	}
}
