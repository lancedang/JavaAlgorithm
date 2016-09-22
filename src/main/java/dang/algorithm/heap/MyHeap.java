package dang.algorithm.heap;

/**
 * 用堆实现优先级队列，默认树顶是最大值
 * 
 * @author Dangdang
 *
 */
public class MyHeap {
	private int max; // 数组的最大容量
	private int size; // 当前数组中元素个数
	private MyBean[] beans;

	public MyHeap(int max) {
		size = 0;
		beans = new MyBean[max];
	}

	/**
	 * 插入，插到数组最后位置-为满足完全树；然后向上比较交换父子元素-维持弱序 记住是用数组保存的元素，交换的是数组的元素
	 * 
	 * @param bean
	 */
	public void insert(MyBean bean) {
		beans[size++] = bean;
		if (size == 1) {
			return;
		}
		int pre = (size - 2) / 2;
		int current = size - 1;
		// 层层向上和父节点比较，若大于父节点则交换，知道 根节点

		int key = bean.getId();
		while (pre >= 0) {
			if (beans[pre].getId() < key) {
				swap(pre, current);
			} else {
				break;
			}
			current = pre;
			pre = (current - 1) / 2;
		}
	}

	public void insert2(MyBean bean) {
		beans[size++] = bean;
		if (size == 1) {
			return;
		}
		int pre = (size - 2) / 2;
		int current = size - 1;
		// 层层向上和父节点比较，若大于父节点则交换，知道 根节点
		trickleUp(current);

	}

	public MyBean find(int key) {
		return null;
	}

	/**
	 * delete操作删除的永远是树顶元素-优先级队列的最值
	 * 
	 * @param key
	 *            关键字
	 * @return
	 */
	public MyBean delete() {
		if (size == 0) {
			System.out.println("Empty.");
			return null;
		} else if (size == 1) {
			size--;
			MyBean result = beans[0];
			beans[0] = null;
			return result;
		}

		MyBean result = beans[0]; // 保留树顶，作为最后结果
		beans[0] = beans[size - 1]; // 将最后一个叶子结点 覆盖堆顶，然后开始shift down
		int index = size - 2; // 元素下标范围

		int current = 0;
		int large;

		while (2 * current < index) { // 至少存在一个节点（左节点）

			MyBean temp = beans[current];

			int left = current * 2 + 1;
			int right = current * 2 + 2;

			if (right <= index && beans[left].getId() < beans[right].getId()) { // 只有
																				// 右节点存在，且大于左节点时
				large = right;
			} else {
				large = left;
			}

			if (beans[current].getId() >= beans[large].getId()) { // 拿树顶和最大节点做比较，若大于节点则下滑，否则退出
				break;
			}

			beans[current] = beans[large]; // 将子节点上移 覆盖 父节点

			beans[large] = temp;
			current = large;

		}
		size--;
		return result;
	}

	public MyBean delete2() {
		if (size == 0) {
			System.out.println("Empty.");
			return null;
		} else if (size == 1) {
			size--;
			MyBean result = beans[0];
			beans[0] = null;
			return result;
		}

		MyBean result = beans[0]; // 保留树顶，作为最后结果
		beans[0] = beans[size - 1]; // 将最后一个叶子结点 覆盖堆顶，然后开始shift down
		size--;

		int current = 0;

		trickleDown(current);

		return result;
	}

	public void swap(int a, int b) {
		MyBean temp = beans[a];
		beans[a] = beans[b];
		beans[b] = temp;
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.println("id=" + beans[i].getId() + "; name=" + beans[i].getName());
		}
		System.out.println("..............................");
	}

	/**
	 * 堆是弱序，完全二叉树，用数组存放，插入的时候，新值先放到数组末尾，然后向上过渡，数组之前的元素都满足堆 向上比较，若大于父节点则
	 * 
	 * @param current
	 *            新元素在数组中的下标，最后位置
	 */
	public void trickleUp(int current) {
		MyBean newBean = beans[current];
		int pre = (current - 1) / 2;
		while (pre >= 0) {
			if (beans[pre].getId() < newBean.getId()) {
				swap(current, pre);
			} else {
				break;
			}
			current = (current - 1) / 2;
			pre = (current - 1) / 2;
		}

	}

	/**
	 * 将下标为index的元素向下比较，若有子节点关键字值大于其，则将他们交换 注意这里面不是两两交换(复杂度
	 * 3*n)的，而是先保存顶层元素，向上层层覆盖，最后再 赋值(复杂度 n-1)
	 * 
	 * @param index
	 *            删除时，取最后一个元素置到树顶，index表示置到树顶后该元素下标
	 */
	public void trickleDown(int index) {
		MyBean tep = beans[index];
		while (2 * index < size - 1) { // index为最后元素置到树顶后的下标，现要将其向下过渡，直到其没有子元素
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			int large;
			if (right <= (size - 1) && beans[right].getId() > beans[left].getId()) {
				large = right;
			} else {
				large = left;
			}
			if (beans[large].getId() <= tep.getId()) {
				break;
			}
			beans[index] = beans[large];
			// beans[large] = tep;
			index = large;
		}

		beans[index] = tep;

	}

}
