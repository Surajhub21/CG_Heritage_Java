# Simple KBC Game

A small Java console game where:
- Questions are shown one by one
- Correct answers give points
- After each correct answer, the player can continue or take the points and leave
- If a wrong answer is given, the game ends and only completed level points are kept
- Each level has 3 questions

## Code Structure

- `Main.java` - application entry point
- `KbcGame.java` - game flow and scoring logic
- `GameData.java` - question and level data
- `Question.java` - question model
- `Level.java` - level model
- `ConsoleInput.java` - input handling
- `SoundPlayer.java` - placeholder sound/voice location

## Sound / Voice Placeholder

The code expects the correct-answer sound file at:

```text
src/assets/correct_answer.mp3
```

You can replace that file later with your own voice or sound clip.

## Run on Windows Command Prompt

From the project folder:

```bat
cd /d "D:\All Programme File\Others\CG_Heritage_Java\Day15Porject"
javac src\*.java
java -cp src Main
```

## Notes

- The project uses only standard Java libraries.
- If `correct_answer.mp3` is not present, the game will print the placeholder path instead of playing audio.
- Java Sound API does not reliably play MP3 without extra libraries, so the sound class currently acts as a placeholder and prints the file location.

