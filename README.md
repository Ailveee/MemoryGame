
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

```
MemoryGame/
├── src/
│   ├── Main.java
│   ├── MemoryGameFrame.java
│   ├── GameBoard.java
│   ├── TileButton.java
│   ├── MenuFrame.java
│   ├── ScoreBoardFrame.java
│   ├── SoundUtils.java
│   └── ScoreManager.java
├── sounds/
│   ├── click.wav
│   ├── success.wav
│   ├── error.wav
│   └── background.wav
├── scores.txt
└── README.md
```

---

## 🚀 How to Run

### Prerequisites

- Java 17 or later (Java 21 recommended)
- IntelliJ IDEA (or any Java IDE)

### Steps

1. Clone or download the project.
2. Open the project in IntelliJ IDEA.
3. Ensure your sound files are placed in the `/sounds` folder at the root.
4. Build the project.
5. Run `Main.java` to start the game.

---

## 🔊 Sound Setup

Place the following `.wav` files in the `sounds/` directory:

- `click.wav` – when a tile is clicked
- `success.wav` – when two tiles match
- `error.wav` – when two tiles do not match
- `background.wav` – background music

> Ensure they are **WAV format**, uncompressed (PCM 16-bit), and correctly named.

---

## 🏆 Scoreboard

Scores are saved in `scores.txt` and displayed after the game ends. The scoreboard tracks:

- Player moves
- Difficulty level
- Best performances

---

## 🔁 Navigation

- Main Menu: Start game, select difficulty, view scoreboard
- Restart: Replay the game without closing
- Return: Go back to the main menu from any screen

---

## 📸 Screenshots

*(Add screenshots here if desired)*

---

## ✅ Future Improvements

- Player name input
- Leaderboard with top scores
- Animated tile flips
- Export as a runnable `.jar` file
- Mute/unmute toggle

---

## 📄 License

Open-source and free for personal or educational use.
