package dang.algorithm.leecode;

public class RemoveLinkedListDaoshuN {
    public static void main(String[] args) {
        //[1,2,3,4,5],2
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = new ListNode();
        ListNode curr = head;

        for (int i : array) {
            ListNode node = new ListNode(i);
            curr.next= node;
            curr = node;
        }
        ListNode h = head.next;
/*        while (h != null) {
            //System.out.println(h.val);
            h = h.next;
        }*/

        ListNode newHead = removeNthFromEnd2(head.next, 2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    public  static ListNode removeNthFromEnd2(ListNode head, int n) {

        //引用复制
        //非常关键：添加empty head节点的思路
        ListNode empty = new ListNode();
        empty.next = head;

        //用于表示倒数第n个节点的pre
        ListNode lastNPre = empty;

        //用于表示倒数第n个节点
        ListNode lastN = head;

        //用于表示lastN的后续节点，这个节点是需要提前往后走几步的节点
        ListNode tail = head;

        //empty, 1,2,3,4 n=1
        //tail先走几步呢？（相对于lastN而言），如果是倒数第1个节点，不需要先走0步
        //如果是倒数第2个，tail晚于lastN，next移动 1步，
        //倒数第3个呢，tail晚于lastN 2步，next移动2步
        //主要是确定n>1还是n>0循环几次的问题，反思
        while(n > 1) {
            tail = tail.next;
            n--;
        }

        //这个地方很容器出错：
        //这里判断条件是tail.next=!null意思是tail最后停在最后一个元素上
        //而不是tail停在最后一个元素的下一个，即不是tail != null
        while(tail.next != null) {
            tail = tail.next;
            lastNPre = lastNPre.next;
            lastN = lastN.next;
        }

        //这里就没啥了，链接指向即可
        lastNPre.next = lastN.next;

        return empty.next;

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode empty = new ListNode();
        empty.next = head;

        ListNode curr = empty;
        ListNode first = head;
        ListNode second = head;

        //比如n=2;
        while (n > 0) {
            second = second.next;
            n--;
        }


        while (second != null) {
            second = second.next;
            first = first.next;
            curr = curr.next;

        }

        curr.next = first.next;

        return empty.next;


    }
}
