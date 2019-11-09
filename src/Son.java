import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Son{
    //定义入栈结构体
    private static class Operator {
        char oper;   //操作符
        int degree;  //优先级
        Operator(char oper, int degree) {
            this.degree = degree;
            this.oper = oper;
        }
    }
    private static String convertExpr(String infix) {
        StringBuffer postfix = new StringBuffer();
        Stack<Operator> s = new Stack<Operator>(); //申请一个栈用来存放操作符
        int n = infix.length();
        for (int i = 0; i < n; i++) {  //逐个遍历每一个字符
            char c = infix.charAt(i);
// 当遇到‘）’的时候我们需要依次从栈顶弹出符号，直到遇到‘（’，并且要将‘（’弹出。
            if (c == ')') {
                while (!s.isEmpty()&&s.peek().oper != '(') {
                    postfix.append(s.peek().oper);
                    s.pop();
                }
                s.pop();   //将‘（‘弹出
            }
// 直接压栈
            else if (c == '(') {
                Operator operator  = new Operator(c, 0);
                s.push(operator);
            }
// 
            else if (c == '-'||c == '+') {
                Operator operator  = new Operator(c, 1);
                while (!s.isEmpty()&&operator.degree <= s.peek().degree) {
                    postfix.append(s.peek().oper);
                    s.pop();
                }
                s.push(operator);
            }
            else if (c == '*'||c == '/') {
                Operator operator  = new Operator(c, 2);
                while (!s.isEmpty()&&operator.degree <= s.peek().degree) {
                    postfix.append(s.peek().oper);
                    s.pop();
                }
                s.push(operator);
            }
            else {
                postfix.append(c);
            }
        }
// 遍历完后将栈中所有元素抛出
        while (!s.isEmpty()) {
            postfix.append(s.peek().oper);
            s.pop();
        }
        return postfix.toString();
    }
    public static void main(String[] args) {
        String infix = null;
        System.out.println("Please enter Infix expression:");
// 读取中缀表达式
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        try {
            infix = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

// 输出后缀表达式
        System.out.println("The Postfix is :\n"+convertExpr(infix));

    }
}