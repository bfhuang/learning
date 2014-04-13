package student;

import java.util.Arrays;
import java.util.List;

public class StudentService {

	public List<Student> getAllStudent() {
		return Arrays.asList(new Student("studentOne", 50),
				new Student("studentTwo", 60),
				new Student("studentThree", 70));
	}
}
