package src._2023_12_13;

import java.util.Queue;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] args) {
        StackImpl<String> stack = new StackImpl<>();
        String str = "Anna";
        String str1 = "Anna1";
        String str2 = "Anna2";
        stack.put(str);
        stack.put(str1);
        stack.put(str2);
        System.out.println(stack.get());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.get());
        System.out.println(stack);
        String string = "Liubov";
        System.out.println(reverse(string));
        QueueClass<String> queue = new QueueClass<>();
        queue.put(str);
        queue.put(str1);
        queue.put(str2);
        queue.put(string);
        System.out.println(queue);
        printInReverse(queue);
        rotate(queue, 2);
        System.out.println(queue);
        Map<String, String> map = new HashMap<>();
        map.put("A", "C");
        map.put("B", "D");
        System.out.println(map);
        replacingValueViaKey(map, "A", "M");
        System.out.println(map);
        Map<String, String> invertMap = invert(map);
        System.out.println(invertMap);
        String string1 = "Abcd";
        String string2 = "Dbac";
        System.out.println(areAnagrams(string2, string1));
        Stack<String> stringStack = new Stack<>();
        stringStack.add("Aaaa");
        stringStack.add("Bbbb");
        stringStack.add("Cccc");
        Stack<String> stringStack1 = new Stack<>();
        stringStack1.add("Aaaa1");
        stringStack1.add("Bbbb2");
        stringStack1.add("Cccc3");
        QueueClass<String> queue1 = new QueueClass<>();
        QueueClass<String> queue2 = new QueueClass<>();
        Queue<String> queue3 = new LinkedBlockingQueue<>();
        queue1.put("Qqqq");
        queue1.put("Wwww");
        queue2.put("Eeee");
        queue2.put("Tttt");
        queue3.add("Qqqq");
        queue3.add("Wwww");
        queue3.add("Eeee");
        queue3.add("Tttt");
        Map<Stack<String>, QueueClass<String>> map1 = new HashMap<>();
        Map<Stack<String>, Queue<String>> map2 = new HashMap<>();
        map2.put(stringStack, queue3);
        map2.put(stringStack1, queue3);
        map1.put(stringStack, queue1);
        map1.put(stringStack1, queue2);
        printMapContents(map1);
        System.out.println(containsElement(map2, "Tttt"));


    }

    public static boolean containsElement(Map<Stack<String>, Queue<String>> map, String element) {
        for (Map.Entry<Stack<String>, Queue<String>> m : map.entrySet()) {
            if (m.getKey().contains(element)||m.getValue().contains(element)) {
                return true;
            }
        }
        return false;
    }

    public static void printMapContents(Map<Stack<String>, QueueClass<String>> map) {
        for (Map.Entry<Stack<String>, QueueClass<String>> m : map.entrySet()) {
            Stack<String> s = m.getKey();
            QueueClass<String> q = m.getValue();
            printStack(s);
            printQueue(q);
            System.out.println();
        }
    }

    public static void printQueue(QueueClass<String> queueClass) {
        while (!queueClass.isEmpty()) {
            System.out.print(queueClass.pop() + ", ");
        }
    }

    public static void printStack(Stack<String> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");

        }
    }

    public static Map<String, String> invert(Map<String, String> map) {
        if (map.isEmpty()) {
            System.out.println("Thies map is empty");
            return null;
        }
        Map<String, String> invert = new HashMap<>();
        for (Map.Entry<String, String> m : map.entrySet()) {
            invert.put(m.getValue(), m.getKey());
        }
        return invert;
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.println("These lines are identical");
            return false;
        }
        String lowerCase1 = str1.toLowerCase(Locale.ROOT);
        String lowerCase2 = str2.toLowerCase(Locale.ROOT);
        char[] string1 = lowerCase1.toCharArray();
        char[] string2 = lowerCase2.toCharArray();
        Arrays.sort(string2);
        Arrays.sort(string1);
        if (!Arrays.equals(string1, string2)) {
            return false;
        }
        return true;
    }

    public static void replacingValueViaKey(Map<String, String> map, String key, String newValue) {
        for (Map.Entry<String, String> m : map.entrySet()) {
            if (!map.containsKey(key)) {
                System.out.println(" There is no such key in this HashMap");
                break;
            } else if (key.equals(m.getKey())) {
                m.setValue(newValue);
            }


        }
    }

    public static void rotate(QueueClass<String> queue, int k) {
        if (!queue.isEmpty()) {
            for (int i = 0; i < k; i++) {
                String str = queue.pop();
                queue.put(str);
            }
        }

    }

    public static void printInReverse(QueueClass<String> queue) {
        if (!queue.isEmpty()) {
            for (int i = queue.arrayList.size() - 1; i >= 0; i--) {
                System.out.print(queue.arrayList.get(i) + ", ");
            }
        }
    }

    public static String reverse(String str) {
        if (str.isEmpty()) {
            System.out.println(" String is empty ");
        }
        char[] chars = str.toCharArray();
        Stack<Character> stack = filingStake(chars);
        chars = filingStake(stack);

        return String.valueOf(chars);
    }

    public static char[] filingStake(Stack<Character> stack) {
        char[] chars = new char[stack.size()];
        if (!stack.isEmpty()) {
            for (int i = 0; i < chars.length; i++) {
                chars[i] = stack.pop();
            }
        }
        return chars;
    }

    public static Stack<Character> filingStake(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            stack.add(c);
        }
        return stack;
    }
}
