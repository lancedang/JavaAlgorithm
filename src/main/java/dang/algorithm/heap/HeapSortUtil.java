package dang.algorithm.heap;

public class HeapSortUtil {
	private MyHeap heap;

	public HeapSortUtil() {
		heap = new MyHeap(100);
	}

	public MyBean[] heapSort(MyBean[] beans) {
		for (MyBean bean : beans) {
			heap.insert(bean);
		}
		heap.show();
		for (MyBean bean : beans) {
			bean = heap.delete();
			bean.display();
		}
		return beans;
	}
}
