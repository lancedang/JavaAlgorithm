package dang.algorithm.heap;

public class MyBean {
	private int id;
	private String name;

	public MyBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void display() {
		System.out.println("id is " + id + ", name is " + name);
	}

}
