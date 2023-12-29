package src.java13_12_23;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
        rotate(queue,2);
        System.out.println(queue);
        Map<String, String> map = new HashMap<>();
        map.put("A", "C");
        map.put("B", "D");
        System.out.println(map);
        System.out.println("________");
        replacingValueViaKey(map,"A","M");
        System.out.println(map);
        System.out.println("++++++++");
        Map<String,String> invertMap=invert(map);
        System.out.println(invertMap);



    }

    public static Map<String, String> invert(Map<String, String> map){
        if(map.isEmpty()){
            System.out.println("Thies map is empty");
            return null;
        }
        Map<String, String> invert=new HashMap<>();
        for (Map.Entry<String,String> m: map.entrySet()){
            invert.put(m.getValue(),m.getKey());
        }
        return invert;
    }
public  static boolean areAnagrams(String str1, String str2){
        if(str1.equals(str2)){
            System.out.println("Эти строки одинаковы");
            return true;
        }
        char[] string1 = str1.toCharArray();
        char[] string2 = str2.toCharArray();

        //надо доделать

        return true;
}
public  static void replacingValueViaKey(Map<String, String>map,String key,String newValue){
            if(!map.containsKey(key)){
                System.out.println(" There is no such key in this HashMap");
            }else{
               map.put(key,newValue);
            }
}
    public static void rotate(QueueClass<String> queue, int k) {
        if (!queue.isEmpty()) {
            for (int i = 0; i < k; i++) {
            String str=queue.pop();
            queue.put(str);
            }
        }
    }

    public static void printInReverse(QueueClass<String> queue) {
        if (!queue.isEmpty()) {
            for (int i = queue.arrayList.size() - 1; i >= 0; i--) {
                System.out.println(queue.arrayList.get(i));
            }
        }
    }

    public static String reverse(String str) {
        if (str.isEmpty()) {
            return "String is empty ";

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
