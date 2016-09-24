package dang.algorithm.linklist;

/**
* LinkList is just like a container which contains 
*
*/
public class SortedLinkList {
	private Link first;
	private int size;
	
	public SortedLinkList() {
		first = null;
		size = 0;
	}
	
	/**
	* Provided sorted in ascending
	*
	*/
	public void insert(Link link) {
		
		//insert and then keep its sorted
		Link previous = null;
		Link current = first;
		
		/** Judgement is crucial **/
		while(current != null && current.getId() < link.getId()) {
			previous = current;
			current = current.getNext();
		} 
		/**
		* Three results appear after above loop operation
		* 1) current is null at the beginning(list is null) or else previous can't be null
		* 2) current.id > link.id in the middle
		* 3) current is null in the end
		*/
		
		/** 1. The list is null only when previou is null  **/
		if(previous == null) {
			first = link;
		} else if(current != null){
			link.setNext(current);
			previous.setNext(link);
		}else {
			previous.setNext(link);
		}
	}
	
	public void insertFirst(Link l) {
		l.setNext(first);
		first = l;
	}
	
	public void show() {

		//we employ a variable ll not first directly 
		//cause the use of first will affect the other method  which use first because the first has changed to null
		//the first is common variable ,every method will use it
		//Doesn't need to delete the first elements, just need a pointer to move one by one.
		Link ll = first;
		while(ll!= null) {
			ll.displayLink();
			ll = ll.getNext();
		}
		
		/**
		Link l0 = first;
		Link l1 = l0.getNext();
		Link l2 = l1.getNext();
		Link l3 = l2.getNext();
		
		var != null;
		var = var.getNext();
		**/
		
	}
	
	/**
	* 
	*
	*/
	public void removeFirst() {
		if(first != null) {
			first = first.getNext();
			size --;
		}else {
			System.out.println("Sorry, the List is empty. ");
		}
	}
	
	public Link removeFirst2() {
		if(first != null) {
			Link ll = first;
			first = first.getNext();
			size --;
			return ll;
		}else {
			System.out.println("Sorry, the List is empty. ");
			return null;
		}
	}
	
	/**
	* Move to the last but one, and delete the last
	* Implement with two pointer
	*/
	public Link removeLast() {
		Link link = first;
		Link pre = first;
		if(isEmpty()) {
			System.out.println("Sorry, the List is empty. ");
			return null;
		}else if (size() == 1)  {
			first = null;
			size --;
			return link;
		}else {
			while (pre != null ) {
				link = pre.getNext();
				if(link.getNext() == null) {
					pre.setNext(null);
					size --;
					break;
					
				}else {
					pre = pre.getNext();
				}
			}
			//note that return is not in while {}
			return link;
		}
	}
	
	public Link peek() {
		return first;
	}
	
	public Link find(int id) {
		Link ll = first;
		while(ll != null) {
			if(ll.getId() == id) {
				return ll;
			} else {
				ll = ll.getNext();
			}
		}
		return null;
	}
	
	/**
	* Implement with only one pointer
	*
	*/
	public void remove(int id) {
		Link head = first;
		if (head.getId() == id ) {
			this.removeFirst();
		}else {
			while (head.getNext() != null) {
				if(head.getNext().getId() ==  id) {
					head.setNext(head.getNext().getNext());
					size --;
					break;
				} else {
					head = head.getNext();
				}
			}
		}	

	}
	
	/**
	* Implement with two pointer
	* @param id is the test criteria
	*/
	public Link remove2(int id) {
		Link l1 = first;
		Link l2 = first;
		
		if(isEmpty()) {
			System.out.println("LinkList is null.");
			return null;
		} else {
			if(l1.getId() == id) {
				first = l1.getNext();
				return l1;
			} else {
				
				while (l1.getNext() != null) {
					//must establish the previous-current relationship every round
					l2 = l1.getNext();  
					if(l2.getId() == id) {
						l1.setNext(l2.getNext());
						size --;
						return l2;
						//break;
					} else {
						l1 = l1.getNext();
					}
				}
				
				return null;
				
			}
		}
		
	}
	
	public boolean insertAfter(int id, Link link) {
		//1.find
		//2.insert
		//if not found, insert into the first position
		Link head = first;
		if(head == null) {
			head = link;
			return true;
		} else {
			while (head != null) {
				//find the place, and insert link after it
				if (head.getId() == id) {
					link.setNext(head.getNext());
					head.setNext(link);
					size ++;
					return true;
					//break;
				}else {
					head = head.getNext();
				}
			}
			
			//if not found ,then insert into first;but how can I make sure
			link.setNext(first);
			first = link;
			return true;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
}