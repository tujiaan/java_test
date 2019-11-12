import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 2  * 快速排序：Java
 3  *
 4  * @author skywang
 5  * @date 2014/03/11
 6  */
 public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public  void push(int node) {
        stack1.push(node);

    }
    public  int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();

    }
    private static void quickSort(int[] a, int l, int r) {
                if (l < r) {
                         int i,j,x;

                         i = l;
                         j = r;
                        x = a[i];
                         while (i < j) {
                                 while(i < j && a[j] > x)
                                         j--; // 从右向左找第一个小于x的数
                                 if(i < j)
                                     a[i++] = a[j];
                                 while(i < j && a[i] < x)
                                        i++; // 从左向右找第一个大于x的数
                                 if(i < j)
                                         a[j--] = a[i];
                             }
                         a[i] = x;
                         quickSort(a, l, i-1); /* 递归调用 */
                         quickSort(a, i+1, r); /* 递归调用 */
                     }
             }
    private static void maoPaoSort(int[] a) {
        /*
        *
        *
        * */
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                int temp=0;
                if(a[j]>=a[j+1]){
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }

            }
        }

    }
    private   static boolean findElementInArray(int target, int [][] array) {
        boolean in=false;
        for(int i=0;i < array.length;i++){
            for(int j=0;j < array[i].length;j++){
                if(target==array[i][j]){
                    in=true;
                    break;
                }
            }
        }
        return in;
    }
    private static void replaceCharInString(StringBuffer str){
      String strings=str.toString().replaceAll(" ","%20");
      System.out.println(strings);
    }
    private  static int minNumberInRotateArray(int [] array) {
         int j=-1;
        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                j=i+1;
                break;
            }
        }
        return array[j];
    }
    private static int Fibonacci(int n) {
        if(n==0){
           return 0;
       }
       if(n==1){
           return 1;
       }else{
           return Fibonacci(n-1)+Fibonacci(n-2);
       }
    }
    private static int JumpFloorII(int target) {
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }else{
            return 2*JumpFloorII(target-1);
        }
    }
    private static int RectCover(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
    private static int NumberOf1(int n) {
        /**
         * @use return the count of 1 in a int number (binary form)
         * @undo understand the principle  of  original code  opposite code etc...
         * */
        int num=0;
        String data;
        if(n>=0) {
            data = Integer.toBinaryString(n);
        }else{
            data=Integer.toBinaryString(n);
        }
        char[] array = data.toCharArray();
        for(char ar:array){
            if(ar=='1'){
                num++;
            }
        }
       return num;

    }

    private static double Power(double base, int exponent) {
        /**
         * @use solve math pow(x,y)
         * */
        double sum=1.0;
        int i=0;
        if (base == 0.0 || exponent == 0) {
            return 1.0;
        }
        while(i<=exponent){
            sum *= 2.0;
            i++;
        }
        return sum;
    }

    private static int ReverseList(ListNode head) {
        /**
         * @doc reverse ListNode(pre defined) and return the headNode
         * @input defined listNode head
         * @return the head of the ListNode
         * @ideal use three pointer to record and point to the node
         * */
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode nex = cur.next;
        pre.next = null;
        cur.next = pre;
        while (nex != null) {
            pre = cur;
            cur = nex;
            nex = cur.next;
            cur.next = pre;

        }
        return cur.val;

    }

    private static int maxSubArray(int[] nums) {
        /**
         * @use get the max continue sequence's sum
        //         * */

        if (nums.length == 1) {
            return nums[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            list.add(sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        return Collections.max(list);
    }

    private static void test() {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int n = in.nextInt();
//            int m = in.nextInt();
//            HashSet<Integer> hashset = new HashSet<Integer>();
//            for(int i = 0; i < n; i++){
//                hashset.add(in.nextInt());
//            }
//            for(int i = 0; i < m; i++){
//                hashset.add(in.nextInt());
//            }
//            Object[] arr = hashset.toArray();
//            int[] array = new int[arr.length];
//            for(int i = 0; i < array.length; i++){
//                array[i] = (int) arr[i];
//            }
//            Arrays.sort(array);
//            for(int i = 0; i < array.length; i++){
//                System.out.print(array[i]+" ");
//            }
//        }
//
//
//    }
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            int n = in.nextInt();
            for (int i = 0; i < 3 * n; i++) {
                arrayList.add(in.nextInt());
            }
            for (int i = 0; i < arrayList.size() / 3; i++) {
                int a = arrayList.get(3 * i);
                int b = arrayList.get(3 * i + 1);
                int c = arrayList.get(3 * i + 2);
                if (b < 1 && c < 1) {
                    arrayList1.add(0);
                } else if (a + b + c < 3) {
                    arrayList1.add(0);
                } else {
                    arrayList1.add((a + b + c) / 3);
                }

            }
            arrayList1.forEach(System.out::println);
        }

    }

    public static void main(String[] args) {
//        StringBuffer stringBuffer=new StringBuffer("we are happy");
//        Solution.replaceCharInString(stringBuffer);
//        Solution solution = new Solution();
//        solution.push(1);
//        solution.push(2);
//        solution.push(3);
//        System.out.println(solution.pop());
//         System.out.println(solution.pop());
//         System.out.println(solution.pop());
//         int[] array={5,6,1,2,3};
//         System.out.println(Solution.minNumberInRotateArray(array));
//           System.out.println(Solution.Fibonacci(5));
//           System.out.println(JumpFloorII(5));
//         System.out.println(Solution.RectCover(10));
//         System.out.println(Solution.NumberOf1(10));
        //System.out.println(Solution.Power(2.0,4));
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        //System.out.println(Solution.ReverseList(a1));
//        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(Solution.maxSubArray(array));
        Solution.test();
    }

 }
