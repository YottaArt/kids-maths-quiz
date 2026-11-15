# Kids Math Quiz

## Overview

Kids Math Quiz is an Android educational game developed as a college assignment using Java and Android Studio. It is designed to help young children practise basic mathematical operations through interactive quizzes.

Each round consists of 10 randomly generated mathematical questions. Players can choose between three difficulty levels, receive audio feedback and track their progress throughout the game.

## Screenshots

### Main Menu

<figure>

<figcaption aria-hidden="true">Main Menu</figcaption>
</figure>

### Difficulty Selection

<figure>

<figcaption aria-hidden="true">Difficulty Selection</figcaption>
</figure>

### Gameplay

<figure>

<figcaption aria-hidden="true">Gameplay</figcaption>
</figure>

## Features

- **Random Questions:** Generates 10 mathematical questions per round.
- **Four Mathematical Operations:** Addition, subtraction, multiplication and division.
- **Three Difficulty Levels:**
  - Level 0 – No time limit.
  - Level 1 – 20 seconds per question.
  - Level 2 – 10 seconds per question.
- **Answer Validation:** Checks the answers entered by the player.
- **Score Tracking:** Counts correct answers and displays the final score.
- **Progress Counter:** Displays the current question number out of 10.
- **Audio Feedback:** Plays different sounds for correct and incorrect answers.
- **Username Validation:** Requires a username between 3 and 20 characters, containing only letters, numbers and underscores.
- **Navigation:** Separate screens for the main menu, difficulty selection and gameplay.

## Mathematical Question Generation

Questions are generated using Java’s `Random` class.

The game includes: - Addition (+) - Subtraction (-) - Multiplication (\*) - Division (÷)

Both operands are randomly generated between 1 and 12.

Subtraction questions are arranged to prevent negative answers. Division uses Java integer arithmetic.

## Technologies Used

| Technology     | Purpose                                    |
|----------------|--------------------------------------------|
| Java 11        | Application logic and game functionality   |
| Android Studio | Development environment                    |
| XML            | User interface layouts                     |
| Android SDK    | Android application development            |
| CountDownTimer | Countdown functionality                    |
| MediaPlayer    | Correct and incorrect answer sound effects |
| Gradle         | Project build configuration                |

## Application Structure

The application contains three main Android Activities:

1.  **MainActivity** – Main menu, username input and validation.
2.  **LevelSelectorMenue** – Difficulty selection.
3.  **GameActivity** – Question generation, answer checking, timers and score tracking.

The `GameEngine` class handles mathematical question generation and calculates the correct answers.

## Testing and Debugging

The application was tested using the Android Studio emulator.

During development, I encountered several issues that helped me improve my understanding of debugging and application logic:

- Questions were not changing correctly after an answer was submitted.
- Repeated submissions could potentially affect the score.
- The question progress counter was not displaying correctly.
- The score was not updating properly on the screen.

These issues required investigating the interaction between the game logic, user input and interface elements.

## Limitations

- Usernames are validated but are not stored permanently.
- The application does not use a database.
- Testing was performed using an Android emulator.
- The game currently uses integer division.

## Building and Running

1.  Download or clone this repository.
2.  Open the `AndroidStudio` project folder in Android Studio.
3.  Allow Gradle to synchronise the project.
4.  Start an Android emulator.
5.  Select **Run** in Android Studio to launch the application.

**Minimum Android version:** Android 7.0 (API 24)

**Target Android version:** Android 16 (API 36)

## Learning Outcomes

This project helped me develop my understanding of:

- Java programming principles and application logic.
- Object-oriented programming and organising code into classes.
- Android Activities and navigation between screens.
- XML layouts and Android user interface design.
- Random number generation and mathematical calculations.
- Event handling, user input and countdown timers.
- Debugging and identifying problems in application behaviour.

The project also helped me gain practical experience working with Android Studio and understanding how Java code interacts with XML-based user interfaces.
