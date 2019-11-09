import java.util.*;

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
    public static double Power(double base, int exponent) {
        double sum=1.0;
        int i=0;
        if(base==0.0||exponent==0){
            return 1.0;
        }
        while(i<=exponent){
            sum*=base;
            i++;
        }
        return sum;
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
        System.out.println(Solution.Power(2.0,4));

     }

 }