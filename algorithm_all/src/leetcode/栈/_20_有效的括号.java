package leetcode.栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * USER:wbpjgs
 * TOTO:todo
 * CLASSNAME: _20_有效的括号
 * DATE: 2020/5/5
 * TIME: 9:57
 * VERSION:1.0.0
 * JDK 1.8
 * url:https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {

    public static void main(String[] args) {
//        System.out.println(isValid("{}[]()"));
//        System.out.println(isValid2("{}[](}"));
        System.out.println(isValid3("{}[](}"));
    }

    private static boolean isValid3(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char value = map.get(stack.pop());
                if (value != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    private static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('{' == c || '(' == c || '[' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (!((pop == '{' && c == '}') || (pop == '(' && c == ')') || (pop == '[' && c == ']'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //这种方法需要查找字符串和替换字符串创建字符串 性能很差
    private static boolean isValid1(String s) {
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            s = s.replace("{}", "");
            s = s.replace("()", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }
}
