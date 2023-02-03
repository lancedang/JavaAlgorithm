package dang.algorithm.leecode;

import dang.algorithm.linklist.Link;
import dang.algorithm.linklist.LinkList;

import javax.naming.LimitExceededException;
import java.util.*;

/**
 * 合并两个链表：从前往后每个相应节点相加，并进位（超过10）向后加十分位上的值
 * 比如，link1: 3->4->5, link2: 6->7->8, 相加后 9->1->4->1
 *
 * @author  dangdang
 */
public class Add2Link {

    /**
     * 返回各位相加后的链表
     * @return
     */
    public static Link add2Link(Link link1, Link link2) {

        //问题1：需要一个指向返回链表头的LinkNode，该node可以访问链表所有节点
        // 标记为将要返回的链表头，先mock一个表头，用以代指返回的链表head
        Link head = new Link(0, 0);

        //问题2：需要一个中间过渡指针，指向中间构造的下一个节点
        //标记为随程序不断next的指针，
        Link current = head;

        //问题3：重新设置链表头目的是不更改原来的两个链表head
        Link head1 = link1;
        Link head2 = link2;

        //问题4：如何初始化进位，并参与node节点运算
        // 考虑到进位，可以先设置进位且初值为0，让这个进位可以统一参与到node节点的运算
        int first = 0;

        //问题5：长度不相同的两个链表结尾处理
        //之所以没有用&&做判断，因为方法体判断了每个link的next是否为null，若为null则将数据域设为0即可
        while (head1 != null || head2 != null) {

            //获取各个元素，若其中一个next为null，则将其data设为0
            int id1 = head1 != null ? head1.getId(): 0;
            int id2 = head2 != null ? head2.getId(): 0;

            //计算两个节点和：进位+head1+head2
            int tmp = first + id1 + id2;

            first = tmp / 10;

            //获取个位数
            int second = tmp % 10;

            Link tmpNode = new Link(second, second);
            //head指向新创建的节点
            current.setNext(tmpNode);
            //current 下移
            current = tmpNode;

            //考虑到两个链表长度不同时的next循环情况
            head1 = head1 != null ? head1.getNext(): null;
            head2 = head2 != null ? head2.getNext(): null;

        }

        //当进位大于0且节点遍历完时时需要额外创建新节点
        if (first > 0) {
            current.setNext(new Link(first, first));
        }

        return head.getNext();
    }


    public static void main(String[] args) {
        Link node1 = new Link(1, 3);
        Link node2 = new Link(2, 3);
        Link node3 = new Link(3, 3);

        //构造链表1,首节点node1
        node1.setNext(node2);
        node2.setNext(node3);

        Link node4 = new Link(7, 3);
        Link node5 = new Link(8, 3);
        Link node6 = new Link(9, 3);
        Link node7 = new Link(9, 3);

        //构造链表2，首节点node4
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);

        Link head = add2Link(node1, node4);

        LinkList linkList = new LinkList(head);
        linkList.show();

        List<Integer> list = new ArrayList<>();



    }
}

