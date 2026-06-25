import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class UndoTextEditor {

    public static void main(String[] args) {
        UndoTextEditor editor = new UndoTextEditor();
        editor.type("Hello");
        System.out.println(editor.getText());
        editor.type("world");
        System.out.println(editor.getText());
        editor.type("this");
        System.out.println(editor.getText());
        editor.type("test");
        System.out.println(editor.getText());
        editor.undo();
        System.out.println(editor.getText());
        editor.undo();
        System.out.println(editor.getText());
    }

    private final Deque<String> history = new ArrayDeque<>();
    private final List<String> words = new ArrayList<>();

    public void type(String word) {
        words.add(word);
        history.push(word);
    }

    public void undo() {
        if (history.isEmpty()) return;
        history.pop();
        if (!words.isEmpty()) words.remove(words.size() - 1);
    }

    public String getText() {
        if (words.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(words.get(i));
        }
        return sb.toString();
    }

}

