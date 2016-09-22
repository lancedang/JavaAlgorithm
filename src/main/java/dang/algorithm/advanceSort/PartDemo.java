package dang.algorithm.advanceSort;

public class PartDemo {
	private int max = 2;

	public void say(int max) {
		System.out.println("类属型 max = " + this.max);
		System.out.println("方法内 局部属性 max = " + max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartDemo demo = new PartDemo();
		demo.say(10);
	}
}
