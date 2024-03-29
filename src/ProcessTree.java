import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProcessTree {
    /***
     * @doc 输入两个数组，第一个数组是子线程（子节点），第二个数组是父线程（父节点），删除一个线程会删除此线程的所有子线程，问给出一个要删除的线程，总共要删除掉几个线程？
     */
    public static void main(String[] args) {
        //处理输入数据
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int temp = scanner.nextInt();
        String[] s1 = a.split(" ");
        int[] kids = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            kids[i] = Integer.parseInt(s1[i]);
        }
        String[] s2 = b.split(" ");
        int[] parents = new int[s2.length];
        for (int i = 0; i < s2.length; i++) {
            parents[i] = Integer.parseInt(s2[i]);
        }
        scanner.close();

        //定义队列存储关联节点
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(temp);
        //结果值
        int count = 0;
        //标志符
        boolean flag = false;

        //如果输入的目标线程temp值为0，count--，没有为0的线程
        if (temp == 0)
            count--;
        //判断输入的目标线程temp值在不在kids数组中
        for (int i = 0; i < kids.length; i++) {
            if (kids[i] == temp) {
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println(0);
        //队列处理操作
        while (!queue.isEmpty()) {
            temp = queue.poll();
            for (int i = 0; i < kids.length; i++) {
                if (parents[i] == temp && kids[i] != 0) {
                    queue.offer(kids[i]);
                }
            }
            count++;
        }

        System.out.println(count);
    }
}


