import java.util.ArrayDeque;
import java.util.Deque;

public class StackDemo {

    // Check for balanced parentheses using a Stack - a classic stack problem
    static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((c == ')' && open != '(') ||
                    (c == '}' && open != '{') ||
                    (c == ']' && open != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Evaluate a postfix expression using a stack, e.g. "23+" means 2 + 3
    static int evaluatePostfix(String expression) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (c) {
                    case '+' -> stack.push(a + b);
                    case '-' -> stack.push(a - b);
                    case '*' -> stack.push(a * b);
                    case '/' -> stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("'(a+b)*(c-d)' balanced: " + isBalanced("(a+b)*(c-d)"));
        System.out.println("'([)]' balanced: " + isBalanced("([)]"));
        System.out.println("'{[a+b]*(c)}' balanced: " + isBalanced("{[a+b]*(c)}"));

        System.out.println("Postfix '23+' = " + evaluatePostfix("23+"));
        System.out.println("Postfix '52*4+' = " + evaluatePostfix("52*4+"));

        // Using a stack directly to reverse a string
        Deque<Character> stack = new ArrayDeque<>();
        String text = "Java";
        for (char c : text.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        System.out.println("Reversed using stack: " + reversed);
    }
}
