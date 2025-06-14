# 🧠 Memory Game - Java Swing

A classic tile-based memory matching game built using **Java Swing**, designed to challenge your memory with flipping tiles, scoring, difficulty levels, and sound effects.

---

## 🎮 Game Features

- Memory matching with flipping tiles
- Three difficulty levels: Easy, Medium, Hard
- Scoreboard that tracks your moves and performance
- Sound effects for click, success, error, and background music
- Timer for tracking playtime
- Main menu with the ability to restart, change difficulty, or return
- Simple and clean user interface

---

## 🛠️ Project Structure

MemoryGame/
├── src/
│ ├── Main.java
│ ├── MemoryGameFrame.java
│ ├── GameBoard.java
│ ├── TileButton.java
│ ├── MenuFrame.java
│ ├── ScoreBoardFrame.java
│ ├── SoundUtils.java
│ └── ScoreManager.java
├── sounds/
│ ├── click.wav
│ ├── success.wav
│ ├── error.wav
│ └── background.wav
├── scores.txt
└── README.md

yaml
Copy
Edit

---

## 🚀 How to Run

### Prerequisites

- Java 17 or later (Java 21 recommended)
- IntelliJ IDEA (or any Java IDE)

### Running the Game

1. Clone or download the project.
2. Open the project in IntelliJ IDEA.
3. Ensure your sound files are placed in the `/sounds` folder (at project root).
4. Build the project.
5. Run the `Main.java` file.

---

## 🔊 Sound File Details

Place the following `.wav` files in the `/sounds` directory:

- `click.wav` – plays when a tile is clicked
- `success.wav` – plays when two tiles match
- `error.wav` – plays when two tiles do not match
- `background.wav` – background music during gameplay

⚠️ Make sure the files are in **WAV format**, uncompressed (PCM 16-bit), and named **exactly** as above.

---

## 🏆 Scoreboard

Scores are saved in a file called `scores.txt` and displayed in the scoreboard window. It includes:

- Player name
- Number of moves
- Difficulty level

---

## 🔁 Replay & Navigation

- Return to the main menu at any time
- Restart the game with the same difficulty
- Choose a new difficulty from the main menu

---

## 📸 Screenshots

*(Add screenshots here if you have any)*

---

## ✅ To-Do / Enhancements

- Add player name input
- Add leaderboard
- Add animations or tile flipping effect
- Export as runnable `.jar` file

---

## 📄 License

This project is open-source and free to use for learning and personal use.
