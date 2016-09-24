package dang.algorithm.linklist;

/**
* Link is a simple node example Class,
* In reality, it maybe any Object such as Person that can be add to any Container 
* The difference between Link node and any other Object 
* is that the linknode has a reference attribute that refers to itself
*
*/
public class DoubleDirectLink {
	//link has two data field
	private int id;
	private int data;
	//the variable point to the next link
	private DoubleDirectLink next;
	private DoubleDirectLink previous;
	
	public DoubleDirectLink(int id, int data) {
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
	
	public void setNext(DoubleDirectLink next) {
		this.next = next;
	}
	
	public int getId() {
		return id;
	}
	
	public int getData() {
		return data;
	}
	
	public void setPrevious(DoubleDirectLink previous) {
		this.previous = previous;
	}
	
	public DoubleDirectLink getPrevious() {
		return previous;
	}
	
	/**
	*return object not a variable
	*/
	public DoubleDirectLink getNext() {
		return next;
	}
	
	public void displayLink() {
		System.out.println("id: " + id + ", data: " + data);
	}
}