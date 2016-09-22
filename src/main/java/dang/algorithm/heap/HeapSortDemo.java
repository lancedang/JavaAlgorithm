package dang.algorithm.heap;

public class HeapSortDemo {
	public static void main(String[] args) {
		MyBean[] beans = { new MyBean(52, "b52"), new MyBean(21, "b21"), new MyBean(11, "b11"), new MyBean(122, "b122"),
				new MyBean(100, "b100") };
		HeapSortUtil util = new HeapSortUtil();
		util.heapSort(beans);
		
	}
}
