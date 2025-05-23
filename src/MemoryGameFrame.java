import javax.swing.*;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.nio.file.*;

public class MemoryGameFrame extends JFrame {
    private final String playerName;
    private JLabel scoreLabel;
    private JLabel timerLabel;
    private GameBoard gameBoard;
    private int moves = 0;
    private int elapsedTime = 0;
    private Timer gameTimer;
    private int gridSize = 4; // default
    private Clip backgroundClip;

    public MemoryGameFrame(String playerName) {
        this.playerName = playerName;
        setTitle("Memory Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 750);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        scoreLabel = new JLabel("Moves: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));

        timerLabel = new JLabel("Time: 0s", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(scoreLabel);
        bottomPanel.add(timerLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        setJMenuBar(new MemoryGameMenuBar(
                e -> startNewGame(gridSize),
                e -> System.exit(0),
                e -> {
                    JMenuItem item = (JMenuItem) e.getSource();
                    if (item.getText().contains("2x2")) changeDifficulty(2);
                    else if (item.getText().contains("4x4")) changeDifficulty(4);
                    else if (item.getText().contains("6x6")) changeDifficulty(6);
                },
                e -> {
                    SoundUtils.stopBackgroundMusic(backgroundClip);
                    new MainMenu().setVisible(true);
                    dispose();
                }
        ));

        startNewGame(gridSize);
    }

    private void startNewGame(int size) {
        if (gameBoard != null) remove(gameBoard);

        gridSize = size;
        moves = 0;
        updateScore();

        gameBoard = new GameBoard(gridSize, this::incrementMoves, this::showWinMessage);
        add(gameBoard, BorderLayout.CENTER);

        revalidate();
        repaint();

        startTimer();

        SoundUtils.stopBackgroundMusic(backgroundClip);
        backgroundClip = SoundUtils.playBackgroundMusic("sounds/background.wav");
    }

    private void changeDifficulty(int newGridSize) {
        startNewGame(newGridSize);
    }

    private void incrementMoves() {
        moves++;
        updateScore();
    }

    private void updateScore() {
        scoreLabel.setText("Moves: " + moves);
    }

    private void startTimer() {
        stopTimer();
        elapsedTime = 0;
        timerLabel.setText("Time: 0s");

        gameTimer = new Timer(1000, e -> {
            elapsedTime++;
            timerLabel.setText("Time: " + elapsedTime + "s");
        });
        gameTimer.start();
    }

    private void stopTimer() {
        if (gameTimer != null) gameTimer.stop();
    }

    private void showWinMessage() {
        stopTimer();
        SoundUtils.stopBackgroundMusic(backgroundClip);
        SoundUtils.playSound("sounds/success.wav");
        JOptionPane.showMessageDialog(this,
                "🎉 " + playerName + ", you won in " + moves + " moves!\nTime: " + elapsedTime + " seconds",
                "Congratulations", JOptionPane.INFORMATION_MESSAGE);

        saveScore();
    }

    private void saveScore() {
        try {
            String record = playerName + "," + moves + "," + gridSize + "x" + gridSize + "\n";
            Files.write(
                    Paths.get("scores.txt"),
                    record.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
