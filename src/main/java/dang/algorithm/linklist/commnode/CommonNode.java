package dang.algorithm.linklist.commnode;

import dang.algorithm.linklist.Link;

public class CommonNode {

    public static Link FindFirstCommonNode(Link pHead1, Link pHead2) {
        Link p1 = pHead1;
        Link p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null) ? pHead2 : p1.getNext();
            p2 = (p2 == null) ? pHead1 : p2.getNext();
        }
        //return的时候p1=p2
        return p1;
    }


    public static void main(String[] args) {
        Link link1 = new Link(1, 1);
        Link link2 = new Link(3, 1);
        Link link3 = new Link(5, 1);
        Link link4 = new Link(7, 1);

        Link link5 = new Link(0, 1);
        Link link6 = new Link(2, 1);
        Link link7 = new Link(4, 1);
        Link link8 = new Link(5, 1);



    }

}
