import javax.swing.*;
import java.awt.event.ActionListener;

public class MemoryGameMenuBar extends JMenuBar {
    public MemoryGameMenuBar(ActionListener restartListener, ActionListener exitListener,
                             ActionListener difficultyListener, ActionListener backToMenuListener) {
        JMenu gameMenu = new JMenu("Game");
        JMenuItem restartItem = new JMenuItem("Restart");
        JMenuItem backItem = new JMenuItem("Back to Menu");
        JMenuItem exitItem = new JMenuItem("Exit");

        restartItem.addActionListener(restartListener);
        backItem.addActionListener(backToMenuListener);
        exitItem.addActionListener(exitListener);

        gameMenu.add(restartItem);
        gameMenu.add(backItem);
        gameMenu.add(exitItem);

        JMenu difficultyMenu = new JMenu("Difficulty");
        String[] options = {"Easy (2x2)", "Medium (4x4)", "Hard (6x6)"};
        for (String option : options) {
            JMenuItem item = new JMenuItem(option);
            item.addActionListener(difficultyListener);
            difficultyMenu.add(item);
        }

        add(gameMenu);
        add(difficultyMenu);
    }
}
