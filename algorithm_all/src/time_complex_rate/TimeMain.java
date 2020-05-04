package time_complex_rate;

/**
 * USER:wbpjgs
 * TOTO:时间复杂度计算
 * CLASSNAME: TimeMain
 * DATE: 2020/4/18
 * TIME: 13:10
 * VERSION:1.0.0
 * JDK 1.8
 */
public class TimeMain {
    //在程序中，看中的是时间复杂度，空间复杂度一般不考虑，因为内存很充足
    public static void test1(int n) {

        //14 O(1) 空间复杂度就存储了一个i 所以为O(1)
        //1
        if (n > 10) {
            System.out.println("n > 10");
        } else if (n > 5) { // 2
            System.out.println("n > 5");
        } else {
            System.out.println("n <= 5");
        }
        //1+4+4+4
        for (int i = 0; i < 4; i++) {
            System.out.println("test");
        }

    }

    public static void test2(int n) {
        //1+3n O(n)
        //1+n+n+n
        for (int i = 0; i < n; i++) {
            System.out.println("test");
        }
    }

    public static void test3(int n) {
        //1+3n+3n^2 O(n^2)
        //1+n+n+n(1+n+n+n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }

    public static void test4(int n) {
        //1+48n O(n)
        //1+n+n+n(1+15+15+15)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.println("test");
            }
        }
    }

    public static void test5(int n) {
        //log2(n) O(logn)
        //2^3 = 8
        //8 2
        //4 2
        //2 2
        //1
        while ((n = n / 2) > 0) {
            System.out.println("test");
        }
    }

    public static void test6(int n) {
        //log5(n) O(logn)
        while ((n = n / 5) > 0) {
            System.out.println("test");
        }
    }

    public static void test7(int n) {
        //1+3log2n+2nlog2n O(nlogn)
        //1 +log2n +log2n +log2n(1+n+n)
        for (int i = 1; i < n; i = i * 2) {
            for (int j = 0; j < n; j++) {
                System.out.println("test");
            }
        }
    }

    public static void test10(int n) {
        //1+1+1+1+1+1+n+n+n 6+3n O(n)  空间复杂度为O(n) 开辟了一个数组
        int a = 10;
        int b = 20;
        int c = a + b;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + c);
        }
    }

}
