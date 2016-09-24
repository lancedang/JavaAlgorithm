package dang.algorithm.commonSort;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public void display() {
		System.out.println("firstName: " + firstName );
		System.out.println("lastName: " + lastName );
		System.out.println("age: " + age );
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
}