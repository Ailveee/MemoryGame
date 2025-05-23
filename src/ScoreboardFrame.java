import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import java.util.List;

public class ScoreboardFrame extends JFrame {
    public ScoreboardFrame() {
        setTitle("Scoreboard");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea scoreArea = new JTextArea();
        scoreArea.setEditable(false);

        StringBuilder sb = new StringBuilder("Player Scores:\n\n");
        try {
            List<String> lines = Files.readAllLines(Paths.get("scores.txt"));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    sb.append("Name: ").append(parts[0])
                            .append(", Moves: ").append(parts[1])
                            .append(", Difficulty: ").append(parts[2])
                            .append("\n");
                }
            }
        } catch (Exception e) {
            sb.append("No scores yet.");
        }

        scoreArea.setText(sb.toString());
        add(new JScrollPane(scoreArea), BorderLayout.CENTER);
    }
}
