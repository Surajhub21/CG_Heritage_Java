import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class KbcGame {

    private final List<Level> levels = GameData.createLevels();

    public void run() {
        try (ConsoleInput input = new ConsoleInput()) {

            printWelcomeMessage();

            int securedPoints = 0;

            for (int levelIndex = 0; levelIndex < levels.size(); levelIndex++) {
                Level level = levels.get(levelIndex);

                System.out.println("========================================");
                System.out.println("LEVEL " + (levelIndex + 1) + ": " + level.getName());
                System.out.println("========================================");

                List<Question> questions = level.getQuestions();

                for (int questionIndex = 0; questionIndex < questions.size(); questionIndex++) {

                    Question question = questions.get(questionIndex);
                    System.out.println();
                    System.out.println("Question " + (questionIndex + 1) + ": " + question.getText());

                    String[] options = question.getOptions();

                    for (int i = 0; i < options.length; i++) {
                        System.out.println((i + 1) + ". " + options[i]);
                    }

                    int answer = input.readInt("Your answer (1-" + options.length + "): ", 1, options.length);

                    if (answer == question.getCorrectOption()) {
                        securedPoints += question.getPoints();
                        System.out.println("Correct! You earned " + question.getPoints() + " points.");

                        SoundPlayer s = new SoundPlayer();
                        s.start();

                        System.out.println("Current level points: " + securedPoints);

                        boolean continueGame = input.askContinue();
                        if (!continueGame) {
                            printFinalScore(securedPoints, true);
                            return;
                        }
                    } else {
                        System.out.println("Wrong answer!");
                        System.out.println("Correct answer was: " + question.getCorrectOption() + ". " + options[question.getCorrectOption() - 1]);
                        printFinalScore(securedPoints, false);
                        return;
                    }
                }

                System.out.println();
                System.out.println("Great! You completed Level " + (levelIndex + 1) + ".");
                System.out.println("Your secured points are now: " + securedPoints);
            }

            printFinalScore(securedPoints, true);
        }
    }

    private void printWelcomeMessage() {
        System.out.println("==============================");
        System.out.println("        SIMPLE KBC GAME       ");
        System.out.println("==============================");
        System.out.println("Rules:");
        System.out.println("- Each level has 3 questions.");
        System.out.println("- Correct answer earns points.");
        System.out.println("- After each correct answer you can continue or take points and leave.");
        System.out.println("- If you answer wrong, the game ends and you keep only the completed level points.");
        System.out.println();
    }

    private void printFinalScore(int securedPoints, boolean completedOrExited) {
        System.out.println();
        System.out.println("========================================");
        if (completedOrExited) {
            System.out.println("Game finished!");
        } else {
            System.out.println("Game over!");
        }
        System.out.println("Total secured points: " + securedPoints);
        System.out.println("========================================");
    }
}

