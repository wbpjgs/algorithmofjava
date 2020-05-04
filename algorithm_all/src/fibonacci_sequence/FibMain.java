package fibonacci_sequence;

/**
 * USER:wbpjgs
 * TOTO:计算斐波那契数列
 * CLASSNAME: FibMain
 * DATE: 2020/4/18
 * TIME: 12:19
 * VERSION:1.0.0
 * JDK 1.8
 */
public class FibMain {
    //递归计算斐波那契数列 存在效率问题
    private static int fib1(final int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    //通过循环计算斐波那契数列
    private static int fib2(final int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }


    public static void main(String[] args) {
        System.out.println(fib1(10));
        System.out.println(fib2(10));
    }
}
