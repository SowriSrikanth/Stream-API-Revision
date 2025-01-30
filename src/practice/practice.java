package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Employee
{
	private int id;
	private String name;
	private int age;
	private String gender;
	private String department;
	private int yearOfJoining;
	private double salary;
	
	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
	
	
	
}

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empList=new ArrayList<>();
		//int id, String name, int age, String gender, String department, int yearOfJoining, double salary
		empList.add(new Employee(1, "Amar", 20, "Male", "Sales", 2021, 10000));
		empList.add(new Employee(2, "Akbar", 27, "Male", "Development", 2017, 12000));
		empList.add(new Employee(3, "Antony", 36, "Male", "Support", 2011, 11000));
		empList.add(new Employee(4, "Ram", 21, "Male", "Logistics", 2022, 17000));
		empList.add(new Employee(5, "Rahim", 45, "Male", "Sales", 2019, 35000));
		empList.add(new Employee(6, "Robert", 48, "Male", "Development", 2009, 70000));
		empList.add(new Employee(7, "Albert", 19, "Male", "Support", 2024, 20000));
		empList.add(new Employee(8, "James", 29, "Male", "Logistics", 2021, 18000));
		empList.add(new Employee(9, "Andrew", 43, "Male", "Sales", 2015, 50000));
		empList.add(new Employee(10, "Bertrand", 51, "Male", "Development", 2010, 65000));
		empList.add(new Employee(11, "Caroline", 26, "Female", "Support", 2021, 21000));
		empList.add(new Employee(12, "Yui", 24, "Female", "Logistics", 2022, 16000));
		empList.add(new Employee(13, "Gregory", 32, "Male", "Sales", 2023, 37000));
		empList.add(new Employee(14, "Lance", 37, "Male", "Development", 2014, 42000));
		empList.add(new Employee(15, "Margaret", 29, "Female", "Support", 2018, 30000));
		empList.add(new Employee(16, "Sophia", 23, "Female", "Logistics", 2024, 24000));
		empList.add(new Employee(17, "Anna", 19, "Female", "Sales", 2024, 21000));
		empList.add(new Employee(18, "Vladimir", 25, "Male", "Development", 2022, 37000));
		empList.add(new Employee(19, "George", 41, "Male", "Support", 2016, 75000));
		empList.add(new Employee(20, "Alicia", 38, "Female","Logistics", 2013, 60000));
		
		//1.How many male and female employees in the organization
		
		Map<String, Long> collect1 = empList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));
		
		System.out.println(collect1);
		
		//2.Print names of all departments in the organization
		
		empList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		
		//3.Avg age of male and female employees
		
		Map<String, Double> collect3 = empList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingInt(Employee::getAge)));
		System.out.println(collect3);
		
		//4.Details of highest paid employee
		
		Optional<Employee> collect4 = empList.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.getSalary())));
		System.out.println(collect4.get().toString());
		
		//5.Get Names of all employees who had joined after 2015
		
		empList.stream().filter(e->e.getYearOfJoining()>2015).map(e->e.getName()).forEach(System.out::println);
		
		//6.Count No of employees in each department
		
		Map<String, Long> collect6 = empList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.counting()));
		System.out.println(collect6);
		
		//7.Avg salary of each department
		
		Map<String, Double> collect7 = empList.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.averagingDouble(e->e.getSalary())));
		System.out.println(collect7);
		
		//8.Get details of the youngest male employee
		
		Optional<Employee> collect8 = empList.stream().collect(Collectors.minBy(Comparator.comparing(e->e.getAge())));
		System.out.println(collect8.get().toString());
		
		//9.Who has most working Experience
		Optional<Employee> collect9 = empList.stream().collect(Collectors.maxBy(Comparator.comparing(e->2024-e.getYearOfJoining())));
		System.out.println(collect9.get().toString());
		
		//10.How may female employees are there in sales team
		long count10 = empList.stream().filter(e->e.getGender().equals("Female")).filter(e->e.getDepartment().equals("Sales")).count();
		System.out.println(count10);
		
		//11.Avg salary of male and female employees
		Map<String, Double> collect11 = empList.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingDouble(e->e.getSalary())));
		System.out.println(collect11);
		
		//12.List down names of employees in each department
		Map<String, List<Employee>> collect12 = empList.stream().collect(Collectors.groupingBy(e->e.getDepartment()));
		System.out.println(collect12);
		
		//13.Avg salary and total salary of org
		Double collect13 = empList.stream().collect(Collectors.averagingDouble(e->e.getSalary()));
		Double reduce13 = empList.stream().map(e->e.getSalary()).reduce(0.0,(a,b)->a+b);
		
		System.out.println(collect13+" "+reduce13);
		
		//14.Separate employees of age<25 and >25
		Map<Boolean, List<Employee>> collect14 = empList.stream().collect(Collectors.groupingBy(e->e.getAge()<25));
		System.out.println(collect14);
		
		//15.OldestEmployee-Age and Doj
		Optional<Employee> collect15 = empList.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.getAge())));
		System.out.println(collect15.get().getAge()+" "+collect15.get().getYearOfJoining());
		
		//second highest salaried employee
		Optional<Employee> secondHighest = empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
//		Optional<Employee> thirdHighest = empList.stream().sorted(Comparator.comparing(Employee)
		System.out.println(secondHighest);
		
		List<Employee> listA=empList.stream().filter(i->i.getName().startsWith("A")).collect(Collectors.toList());
		System.out.println(listA);
	}
	

}
