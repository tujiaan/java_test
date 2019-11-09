import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Poland {
    /**
     * @author tujiaan
     * @time 2019-11-8
     * @doc shixianninolanbianhuanhezhongzhiubianhouzhui
     */
    private static String middleToLast() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("please enter expression:");
        char[] exp=scanner.next().toCharArray();
        Stack<Character> stack=new Stack<>();
        ArrayList<Character> list= new ArrayList<>();
        int i=0;
        for(char var:exp){
            //System.out.println(!stack.empty()? stack.peek():null);
            if(var=='('){
                stack.push(var);
            }else if(var==')'){
                while(!stack.empty() && stack.peek()!='('){
                    list.add(stack.pop());
                }
                stack.pop();
            }else if(var=='-'||var=='+'){
                if(!stack.empty() && (stack.peek()=='*'||stack.peek()=='/')){
                    while(!stack.empty()){
                        list.add(stack.pop());
                    }

                }
                stack.push(var);
            }else if(var=='*'|| var=='/'){
                stack.push(var);

            }else{
               list.add(var);
            }
        }
        while(!stack.empty()){
            list.add(stack.pop());
        }
      String string=" ";
        for(char ch:list){
            string+=ch;
        }
       return string;

    }
    private static int reversedPoland(String input){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(a + b));

            } else if (input.charAt(i) == '-') {
                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(b - a));

            } else if (input.charAt(i) == '*') {
                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(a * b));
            } else if (input.charAt(i) == '/') {

                Integer a = Integer.parseInt(stack.pop());
                Integer b = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(b / a));
            } else {
                stack.push(Character.toString(input.charAt(i)));
            }

        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
//        System.out.println(Poland.middleToLast());
        System.out.println(Poland.reversedPoland(Poland.middleToLast()));

    }
}
