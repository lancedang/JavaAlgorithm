package dang.algorithm.linklist;

/**
* Link is a simple node example Class,
* In reality, it maybe any Object such as Person that can be add to any Container 
* The difference between Link node and any other Object 
* is that the linknode has a reference attribute that refers to itself
*
*/
public class Link {
	//link has two data field
	private int id;
	private int data;
	//the variable point to the next link
	private Link next;
	
	public Link(int id, int data) {
		this.id = id;
		this.data = data;
		//next = null;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Link next) {
		this.next = next;
	}
	
	public int getId() {
		return id;
	}
	
	public int getData() {
		return data;
	}
	
	/**
	*return object not a variable
	*/
	public Link getNext() {
		return next;
	}
	
	public void displayLink() {
		System.out.println("id: " + id + ", data: " + data);
	}
}