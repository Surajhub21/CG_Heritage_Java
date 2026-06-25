import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {

    public static void main(String[] args) {
        String[] inputs = {"((()))","[{()}]","({[)]}",""};
        for (String s : inputs) {
            boolean ok = isBalanced(s);
            System.out.println("Input: \"" + s + "\" => " + (ok ? "BALANCED" : "NOT BALANCED"));
        }
    }

    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                if (!matches(t, c)) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

}

