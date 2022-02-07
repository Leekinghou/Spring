package reflection;

/**
 * @author: lijinhao
 * @date: 2022/02/07 13:21
 */


import reflection.reflect.Addition;
import reflection.reflect.MathOperation;
import reflection.reflect.Subtraction;

import java.util.Scanner;

public class count {
    public static void case1() {
        System.out.println("请输入计算类名：\n1. Addtion\n2. Subtraction\n");
        Scanner scanner = new Scanner(System.in);
        String op = scanner.next();
        System.out.println("请输入a:");
        int a = scanner.nextInt();
        System.out.println("请输入b:");
        int b = scanner.nextInt();

        if(op.equals("Addition")){
            MathOperation mathOperation = new Addition();
            System.out.println("结果为：" + mathOperation.operate(a, b));
        }else if(op.equals("Subtraction")){
            MathOperation mathOperation = new Subtraction();
            System.out.println("结果为：" + mathOperation.operate(a, b));
        }else{
            System.out.println("无效的计算类");
        }
    }

    public static void case2() throws Exception{
        System.out.println("请输入计算类名：\n1. Addition\n2. Subtraction\n");
        Scanner scanner = new Scanner(System.in);
        String op = scanner.next();
        System.out.println("请输入a:");
        int a = scanner.nextInt();
        System.out.println("请输入b:");
        int b = scanner.nextInt();
        MathOperation mathOperation = null;
        // 因为newInstance()返回的是一个object对象，因此可以强转为MathOperation对象
        mathOperation = (MathOperation) Class.forName("reflection.reflect." + op).newInstance();
        int result = mathOperation.operate(a, b);
        System.out.println("结果为：" + result);
    }

    public static void main(String[] args) throws Exception {
//        case1();
        case2();
    }
}
