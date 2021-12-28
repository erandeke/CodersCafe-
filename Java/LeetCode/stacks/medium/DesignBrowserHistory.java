package stacks.medium;

import java.util.Stack;

/**
 * @author Kedar Erande
 */
class BrowserHistory {
    Stack<String> history = new Stack<String>();
    Stack<String> future = new Stack<String>();


    public BrowserHistory(String homepage) {
        history.push(homepage);
    }


    public void visit(String url) {
        history.push(url);
        future.clear();
    }

    public String back(int steps) {
        while (steps > 1 && history.size() > 1) {
            future.push(history.pop());
            history.pop();
            steps--;
        }

        return history.peek();
    }


    public String forward(int steps) {
        while (steps > 1 && future.size() > 1) {
            history.push(future.peek());
            future.pop();
            steps--;

        }

        return history.peek();
    }

}


public class DesignBrowserHistory {
    public static void main(String[] args) {

    }

}
