package src._2023_12_13Queue;

import java.util.Stack;

public class Browser {
    private Stack<String> historyStack;

    public Browser() {
        this.historyStack = new Stack<>();
    }

    public void visitPage(String url) {
        historyStack.push(url);
        System.out.println("Visited page: " + url);
    }

    public void goBack() {
        if (!historyStack.isEmpty()) {
            historyStack.pop();
            if (!historyStack.isEmpty()) {
                System.out.println("Back to the page: " + historyStack.peek());
            } else {
                System.out.println("History 0");
            }
        } else {
            System.out.println("History 0");
        }
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.visitPage("page 1");
        browser.visitPage("page 2");
        browser.visitPage("page 3");
        browser.visitPage("page 4");
        browser.visitPage("page 5");
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
    }
}