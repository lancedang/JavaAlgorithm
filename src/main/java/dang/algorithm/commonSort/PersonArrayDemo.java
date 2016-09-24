package dang.algorithm.commonSort;

public class PersonArrayDemo {
	public static void main(String[] args) {
		PersonArray personArray = new PersonArray(10);

		Person p1 = new Person("kai", "qian", 27);
		Person p2 = new Person("qiang", "liu", 26);
		Person p3 = new Person("xue", "zhao", 25);
		Person p4 = new Person("bei", "liu", 70);
		
		personArray.insert(p1);
		personArray.insert(p2);
		personArray.insert(p3);
		personArray.insert(p4);
		
		personArray.displayArray();
		
		personArray.insertSort();
		
		personArray.displayArray();
	}
}