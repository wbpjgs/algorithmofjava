package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: Main
 * DATE: 2020/4/30
 * TIME: 19:49
 * VERSION:1.0.0
 * JDK 1.8
 */
public class Main {
    public static void main(String[] args) {
        reverseString();
//        System.out.println(generateString(5,false));
//        System.out.println(calculateDays("2016-01-03", "2015-01-08"));
        System.out.println(calculateDays("2016-01-03", "2017-01-03"));
        System.out.println(calculateDays("2016-01-03", "2016-03-08"));
        System.out.println(calculateDays("2016-01-03", "2017-02-08"));
        System.out.println(calculateDays("2016-01-03", "2019-06-08"));
    }

    /**
     * @param before 时间1
     * @param after  时间2
     * @return 间隔的天数
     */
    public static int calculateDays(final String before, final String after) {
        int totalDays = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            final Date beforeDate = sdf.parse(before);
            final Date afterDate = sdf.parse(after);
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(beforeDate);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(afterDate);
            //检查时间 before必须小于after
            if (!cal1.before(cal2)) {
                throw new IllegalArgumentException("date is invalid, should be before < after.");
            }
            int day1 = cal1.get(Calendar.DAY_OF_YEAR);
            int day2 = cal2.get(Calendar.DAY_OF_YEAR);

            int year1 = cal1.get(Calendar.YEAR);
            int year2 = cal2.get(Calendar.YEAR);
            if (year1 != year2) {
                //不在同一年
                int timeDistance = 0;
                for (int i = year1; i < year2; i++) {
                    if (isRyear(i))    //闰年
                    {
                        timeDistance += 366;
                    } else    //不是闰年
                    {
                        timeDistance += 365;
                    }
                }

                totalDays = timeDistance + (day2 - day1);
            } else {
                //同一年
                totalDays = day2 - day1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return totalDays;
    }

    //判断是否是闰年
    private static boolean isRyear(final int year) {
        Objects.requireNonNull(year);
        return year % 400 == 0 || year % 4 == 0;
    }

    /**
     * 字符串反转
     */
    public static void reverseString() {
        String str = "wangbaopeng";
        String result = "";
        final char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result += chars[i];
        }
        System.out.println(result);
    }

    /**
     * @param length 生成的字符串长度
     * @param type   生产的字符串中是否要添加特殊字符
     * @return string
     */
    public static String generateString(final int length, final boolean type) {
        char[] chars = {'a', 'b', 'c', '1', '2', '3'}; //一般字符
        char[] teshuChars = {',', '?', '=', '+'}; //特殊字符
        Random random = new Random();
        String result = "";
        if (type) { //添加特殊字符
            char[] resetChar = new char[chars.length + teshuChars.length];
            System.arraycopy(chars, 0, resetChar, 0, chars.length - 1);
            System.arraycopy(teshuChars, 0, resetChar, chars.length, teshuChars.length - 1);
            for (int i = 0; i < length; i++) {
                result += resetChar[random.nextInt(resetChar.length - 1)];
            }
        } else { //不需要添加特殊字符
            for (int i = 0; i < length; i++) {
                final Character aChar = chars[random.nextInt(chars.length - 1)];
                result += aChar;
            }
        }
        return result;
    }
}
