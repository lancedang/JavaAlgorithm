package dang.algorithm.leecode;

public class MergeLinkList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(1, node2);

        ListNode h1 = node3;

        ListNode no1 = new ListNode(10);
        ListNode no2 = new ListNode(8, no1);
        ListNode no3 = new ListNode(5, no2);
        ListNode no4 = new ListNode(2, no3);

        ListNode h2 = no4;


        ListNode listNode = mergeTwoLists(h1, h2);

        while (listNode != null) {
            System.out.println(listNode);
            listNode = listNode.next;
        }

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;

        //1)先起一个empty head，这里需要两个指针，一个用于不断向下走（遍历循环），
        ListNode head = new ListNode(0);
        //另一个代表链头就行（最后输出结果用）
        ListNode result = head;

        //2)最后，两个链表若有一个到达结尾则停止
        while (head1 != null && head2 != null ) {
            int v1 = head1.val;
            int v2 = head2.val;

            ListNode curr = null;

            //3）最小值构造当前node,同时链表向下next走
            if (v1 <= v2) {
                curr  = new ListNode(v1);
                head1 = head1.next;
            }else {
                curr = new ListNode(v2);
                head2 = head2.next;
            }
            //4)当前的head 下一个指向curr
            head.next = curr;
            //5)当前的head 向下走
            head = curr;

        }

        //6)最后补充，较长的链表
        if (head1 != null) {
            head.next = head1;
        }else {
            head.next = head2;
        }
        //7)输出的是我们emtpy head（这个是我们最开始加的）的下一个
        return result.next;

    }
}

class ListNode{
    int val;
    //最关键：知道可以这么用 a.next =
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";
    }
}

