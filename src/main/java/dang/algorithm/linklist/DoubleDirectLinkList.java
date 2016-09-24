package dang.algorithm.linklist;

/**
* LinkList is just like a container which contains 
* Principal: Begin the easiest, and add the harder, 
* 编代码，插入，删除，先易后难，删除，插入从最简单的情况入手，再考虑边界特殊情况；大处着眼，小处着手
*
*/
public class DoubleDirectLinkList {
	//point to the first
	private DoubleDirectLink first;
	//point to the last 
	private DoubleDirectLink last;
	
	private int size;
	
	public DoubleDirectLinkList() {
		first = null;
		last = null;
		size = 0;
	}
	
	public void insertFirst(DoubleDirectLink link) {

		if(isEmpty()) {
			//link.setNext(first);
			first = last = link;			
		}else {
			link.setNext(first);
			first.setPrevious(link);
			first = link;
		}
		size ++;
	}
	
	public void insertLast(DoubleDirectLink link) {
		
		if(isEmpty()) {
			first = last = link;
		}else {
			last.setNext(link);
			link.setPrevious(last);
			last = link;
		}
		
		size ++;
	}
	
	public void insertAfter(DoubleDirectLink dd, DoubleDirectLink link) {
		
		if(isEmpty()) {
			first = last = link;
		}else {
			DoubleDirectLink head = first;
			
			while(head != null) {
				if(head.getId() == dd.getId()) {
					
					break;
				} 
				
				head = head.getNext();
			}
			//while end with two possible, one head is null and insert to the end, the other is right position
			if(head == null) {
				last.setNext(link);
				link.setPrevious(last);
				last = link;
			}else {
				//insert after head 
				link.setNext(head.getNext());
				
				//need to check whether head is end 
				if(head.getNext() != null) {
					head.getNext().setPrevious(link);
				}else {
					last = link;
				}
				
				head.setNext(link);
				link.setPrevious(head);
				
			}
		}
		size ++;
	}
	
	public DoubleDirectLink deleteFirst() {
		if(first == null) {
			return null;
		}else {
			DoubleDirectLink d = first;
			first = first.getNext();
			if(first == null) {
				last = null;
			}else {
				first.setPrevious(null);
			}
			size --;
			return d;
		}
		
	}
	
	public DoubleDirectLink deleteLast() {
		if(first == null) {
			return null;
		}else {		
			DoubleDirectLink d = last;
			last = last.getPrevious();
			if(last == null) {
				first = null;
			}else {
				last.setNext(null);
			}
			size --;
			return d;
		}
	}
	
	
	/**
	* Fisrt find the link, then delete it
	* the delete is complicate, including first, last, middle position
	*/
	public DoubleDirectLink deleteKey(int id) {
		
		DoubleDirectLink head = first;
		if (head == null) {
			System.out.println("List is null.");
			return null;
		}else {			
			while (head != null) {
				if (head.getId() == id) {
					break;
				}else {
					head = head.getNext();
				}
			}
			//after while loop, only two possibility: one getting to the end; the other find the key
			if(head == null) {
				//doesn't exist
				System.out.println("The key doesn't exist.");
				return null;
			}else {
				//head link is the one, we should delete it, 
				//it may stand in first , middle and last position, delete it
				//now, there is one element at least
				if(head == first) {
					first = first.getNext();
					if(first == null) {
						last = null;
					}else {
						first.setPrevious(null);
					}					
				} else if(head == last) {
					//head.getPrevious().setNext(null);
					last = last.getPrevious();
					if (last == null) {
						first = null;
					}else {
						last.setNext(null);
					} 
				}else {					
					head.getPrevious().setNext(head.getNext());
					head.getNext().setPrevious(head.getPrevious());
				}
				size --;
				return head;
			}
			
		}
	}
	
	public void showForward() {

		//we employ a variable ll not first directly 
		//cause the use of first will affect the other method  which use first because the first has changed to null
		//the first is common variable ,every method will use it
		//Doesn't need to delete the first elements, just need a pointer to move one by one.
		DoubleDirectLink ll = first;
		while(ll!= null) {
			ll.displayLink();
			ll = ll.getNext();
		}
		
	}
	
	public void showBackward() {
		
		DoubleDirectLink ll = last;
		while(ll!= null) {
			ll.displayLink();
			ll = ll.getPrevious();
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
}