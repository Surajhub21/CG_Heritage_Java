public class Question {
    private final String text;
    private final String[] options;
    private final int correctOption;
    private final int points;

    public Question(String text, String[] options, int correctOption, int points) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public int getPoints() {
        return points;
    }
}

