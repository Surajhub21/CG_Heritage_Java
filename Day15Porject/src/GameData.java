import java.util.ArrayList;
import java.util.List;

public final class GameData {

    private GameData() {

    }

    public static List<Level> createLevels() {
        List<Level> levels = new ArrayList<>();

        levels.add(new Level(
                "General Knowledge",
                List.of(
                        new Question(
                                "What is the capital of India?",
                                new String[]{"Mumbai", "New Delhi", "Kolkata", "Chennai"},
                                2,
                                100
                        ),
                        new Question(
                                "Which planet is known as the Red Planet?",
                                new String[]{"Earth", "Mars", "Jupiter", "Venus"},
                                2,
                                200
                        ),
                        new Question(
                                "How many continents are there in the world?",
                                new String[]{"5", "6", "7", "8"},
                                3,
                                300
                        )
                )
        ));

        levels.add(new Level(
                "Science and Tech",
                List.of(
                        new Question(
                                "What does CPU stand for?",
                                new String[]{"Central Processing Unit", "Computer Power Unit", "Control Program Unit", "Central Print Unit"},
                                1,
                                500
                        ),
                        new Question(
                                "Which gas do plants absorb from the air?",
                                new String[]{"Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"},
                                3,
                                1000
                        ),
                        new Question(
                                "What is the boiling point of water at sea level?",
                                new String[]{"90°C", "100°C", "110°C", "120°C"},
                                2,
                                2000
                        )
                )
        ));

        levels.add(new Level(
                "Mixed Round",
                List.of(
                        new Question(
                                "Which language is used to create Android apps commonly?",
                                new String[]{"Swift", "Kotlin", "Ruby", "Pascal"},
                                2,
                                3000
                        ),
                        new Question(
                                "Which is the largest ocean on Earth?",
                                new String[]{"Atlantic", "Indian", "Pacific", "Arctic"},
                                3,
                                5000
                        ),
                        new Question(
                                "Who wrote 'Hamlet'?",
                                new String[]{"Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"},
                                2,
                                10000
                        )
                )
        ));

        return levels;
    }
}

