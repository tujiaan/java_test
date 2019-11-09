import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public class Example {


        private static   ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            while (listNode.next!= null) {
                arrayList.add(listNode.val);
                listNode=listNode.next;
            }
            arrayList.add(listNode.val);
            //Collections.reverse(arrayList);
            for(int i=arrayList.size()-1;i>=0;i--){
                list.add(arrayList.get(i));
            }
            //return arrayList;
            return list;
        }


        public static   void main(String[] args) {
            ListNode listNode0 = new ListNode(0);
            ListNode listNode1 = new ListNode(1);
            ListNode listNode2 = new ListNode(2);
            listNode0.next = listNode1;
            listNode1.next = listNode2;
            Example.printListFromTailToHead(listNode0).stream().forEach(System.out::println);


        }
    }
