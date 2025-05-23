import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Memory Game - Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("Memory Game", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JButton startButton = new JButton("Start Game");
        JButton scoreboardButton = new JButton("View Scoreboard");
        JButton exitButton = new JButton("Exit");

        startButton.addActionListener(e -> {
            String playerName = JOptionPane.showInputDialog(this, "Enter your name:");
            if (playerName != null && !playerName.trim().isEmpty()) {
                new MemoryGameFrame(playerName).setVisible(true);
                dispose();
            }
        });

        scoreboardButton.addActionListener(e -> new ScoreboardFrame().setVisible(true));
        exitButton.addActionListener(e -> System.exit(0));

        add(title);
        add(startButton);
        add(scoreboardButton);
        add(exitButton);
    }
}
