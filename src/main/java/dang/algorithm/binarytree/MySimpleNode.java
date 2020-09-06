package dang.algorithm.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MySimpleNode {

	private int value;
	private MySimpleNode leftMyNode;
	private MySimpleNode rightMyNode;

	public MySimpleNode(int value) {
		this.value = value;
	}
}
