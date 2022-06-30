package util;

import java.util.ArrayList;
import java.util.List;
import com.Student;

public class studentDataUtil {
	public static List<Student> getStudents(){
		List<Student> students=new ArrayList<Student>();
		
		students.add(new Student("jhon","dev","jd@gmail.com"));
		students.add(new Student("alex","jhon","aj@e.com"));
		students.add(new Student("pand","ray","pr@eee.com"));
		students.add(new Student("max","jack","mj@rrr.com"));

		return students;
		
	}
}
