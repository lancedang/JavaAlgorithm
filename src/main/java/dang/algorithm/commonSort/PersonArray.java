package dang.algorithm.commonSort;

public class PersonArray {
	private Person[] persons;
	private int number;
	
	public PersonArray(int max) {
		persons = new Person[max];
		number = 0;
	}
	
	public void insert(Person p) {
		persons[number] = p;
		number ++;
	}
	
	public Person find(String key) {
		int i;
		
		if(number == 0) {
			System.out.println("persons is empty.");
			return null;
		}
		
		for(i=0; i<number; i++) {
			if(persons[i].getLastName().equals(key)) {
				System.out.println("persons find.");
				return persons[i];
			}
		}
		System.out.println("person doesn't exists.");
		return null;
		
	}
	
	public void displayArray() {
		System.out.println("persons: ");
		for(int i=0; i<number; i++) {
			persons[i].display();
		}
	}
	
	public boolean delete(String key) {
		int i;
		if(number == 0) {
			System.out.println("persons is empty.");
			return false;
		}
		
		for(i=0; i<number; i++) {
			if(persons[i].getLastName().equals(key)) {
				System.out.println("persons find.");
				break;
			}
		}
		
		if(i == number) {
			System.out.println("person doesn't exists.");
			return false; 
		}
		
		for(int k=i; k<number; k++) {
			persons[k] = persons[k+1];
		}
		
		number --;
		System.out.println("delete success.");
		return true;
		
	}
	
	public void insertSort() {
		for(int i=1; i<number; i++) {
			Person tmp = persons[i];
			int j = i;
			while(j>0 && persons[j].getLastName().compareTo(tmp.getLastName())>=0) {
				persons[j] = persons[j-1];
				j --;
			}
			
			persons[j] = tmp;
			
		}
	}
	
}