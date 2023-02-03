package dang.algorithm.leecode.removerepeat;

import java.util.List;

//    Hongbo Xia (Cisco) 对所有人说：    上午 11:26
//    给定一个已排序的单向链表，请删除数值重复的节点，返回新链表。
//    例如：1->1->2->3->3->3->4->5
//    返回：1->2->3->4->5
//    Hongbo Xia (Cisco) 对所有人说：    上午 11:26
class Solution {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;

       ListNode delete = delete(n1);

       //无论如何判断语句delete != null不能写成 delete.next != null
        //这2个判断逻辑不一样，一个是当前delete不为null就打印当前
        //一个是当前的下一个不为null,才打印当前，相对上面，就少打了一次
       while (delete != null) {
            System.out.println(delete.val);
            delete = delete.next;
        }
        //do-while相对于while-do区别是先判断后执行，还是先执行后判断
//        do {
//            System.out.println(delete.val);
//            delete = delete.next;
//        } while (delete != null); //循环体里已经向next移动了，
                                  // 这里判断就不能用delete.next != null来判断了
                                  // 直接用delete != null来判断
    }

    public static ListNode delete(ListNode head) {
        //1,1,2
        //1,2,3
        //一般不在原来的head索引上操作，独立出2个你需要使用的索引
        ListNode cur = head;
        ListNode second = head.next;

        while (second != null) {
            //其实这里的不等，1种：是连续的不等，2种：是经过second向后移动过后的不等
            if (cur.val != second.val) {

                //这个对1,2,3这种是冗余操作，主要针对的1,1,2这种情况
                //但这个如果一开始以1,2,3为例则会忽略这一步的执行
                cur.next = second;

                //如果不相等，2个指针就一直往后移动
                cur = cur.next;
                second = second.next;
                //加一个移除中间相同元素的逻辑

            } else {
                //若相等second就一直往后找，直到遇到不相等的元素
                second = second.next;
            }
        }

        return head;

    }

    public ListNode deleteDuplicates(ListNode head) {
        //
        //从前往后遍历，直至找到与当前不一样的元素，删除中间的其他元素
        ListNode curr = head;
        ListNode second = head.next;
        while (second != null) {
            if (second.val != curr.val) {
                //1,2，3
                //1,1,2
                curr.next = second;
                curr = second;

                second = second.next;

            } else {
                second = second.next;
            }
        }

        return head;
    }

}