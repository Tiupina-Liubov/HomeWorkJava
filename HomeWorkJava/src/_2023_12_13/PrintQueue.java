package src._2023_12_13;

import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue {
    private Queue<String> queue;

    public PrintQueue() {
        this.queue = new LinkedList<>();
    }

    public void addToPrint(String str) {
        queue.add(str);
        System.out.println("Added: " + str);
    }

    public void doPrint() {
        if(!queue.isEmpty()) {
            System.out.println("Print: " + queue.remove());
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        printQueue.addToPrint("Q");
        printQueue.addToPrint("QW");
        printQueue.addToPrint("QWE");
        printQueue.addToPrint("QWERT");
        printQueue.addToPrint("QWERTY");

        printQueue.doPrint();
        printQueue.doPrint();
        printQueue.doPrint();
        printQueue.doPrint();
        printQueue.doPrint();
    }
}
