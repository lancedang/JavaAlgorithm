package dang.algorithm.merge;

public class HanoiTower {
	/**
	 * 将层数为disk的盘子 转移
	 * @param disk 盘子层数
	 * @param from 初始盘子所处的tower
	 * @param inner 中间可借用的tower
	 * @param to	最后的目的tower
	 */
	public static void moveDisk(int disk, char from, char inner, char to) {
		if (disk == 1) {
			System.out.println("move 1 from " + from + " to " + to);
		} else {
			moveDisk(disk - 1, from, to, inner);
			System.out.println("move " + disk + " from " + from + " to " + to);
			moveDisk(disk - 1, inner, from, to);
		}
	}

	public static void main(String[] args) {
		int disk = 3;
		moveDisk(disk, 'A', 'B', 'C');
	}

}
