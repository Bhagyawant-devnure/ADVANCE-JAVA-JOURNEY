import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tester {

	private static final String RED = "\033[1;31m"; // RED
	private static final String RESET = "\033[0m"; // Text RESET

	public static void main(String[] args) {
		List<Employee> list = EmployeeAdder.addDetails();
		Set<Integer> set = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		//1.Filter Employees by Gender:
		//Retrieve a list of all female employee
		System.out.println(RED+"*****Retrieve a list of all femal employes***"+RESET);
	list.stream().filter(t-> t.getGender().equals("Female")).forEach(System.out::println);
	
	}

}
