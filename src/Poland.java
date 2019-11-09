import java.util.*;

public class Poland {
    /**
     * @author tujiaan
     * @time 2019-11-8
     * @doc shixianninolanbianhuanhezhongzhiubianhouzhui
     */
    private static String middleTolast(){
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
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Poland.middleTolast());

    }
}
