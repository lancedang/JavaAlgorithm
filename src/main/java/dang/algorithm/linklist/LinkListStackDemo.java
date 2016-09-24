package dang.algorithm.linklist;

public class LinkListStackDemo {
	public static void main(String[] args) {
		
		LinkListStack listStack1 = new LinkListStack();
		
		
		Link l1 = new Link(1, 11);
		Link l2 = new Link(2, 22);
		Link l3 = new Link(3, 33);
		
		System.out.println("Insert l1: ");
		listStack1.push(l1);
		
		System.out.println("Insert l2: ");
		listStack1.push(l2);
		
		System.out.println("Insert l3: ");
		listStack1.push(l3);
		
		System.out.println("the list size is " + listStack1.size());
		listStack1.show();
		
		Link pop1 = listStack1.pop();
		
		System.out.println("the poped elements is ");
		pop1.displayLink();
		
		System.out.println("the list after pop is ");
		listStack1.show();
		
	}
}