import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameBoard extends JPanel {
    private final int totalPairs;
    private int matchedPairs = 0;
    private TileButton firstSelected = null;
    private TileButton secondSelected = null;
    private final Timer flipBackTimer;
    private final Runnable onMove;
    private final Runnable onWin;

    public GameBoard(int gridSize, Runnable onMove, Runnable onWin) {
        this.onMove = onMove;
        this.onWin = onWin;
        this.totalPairs = (gridSize * gridSize) / 2;

        setLayout(new GridLayout(gridSize, gridSize));
        ArrayList<Integer> tileValues = generateTileValues();

        for (int value : tileValues) {
            TileButton tile = new TileButton(value);
            tile.addActionListener(new TileClickListener());
            add(tile);
        }

        flipBackTimer = new Timer(1000, e -> {
            if (firstSelected != null && secondSelected != null) {
                firstSelected.hideValue();
                secondSelected.hideValue();
                firstSelected = null;
                secondSelected = null;
            }
        });
        flipBackTimer.setRepeats(false);
    }

    private ArrayList<Integer> generateTileValues() {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i <= totalPairs; i++) {
            values.add(i);
            values.add(i);
        }
        Collections.shuffle(values);
        return values;
    }

    private class TileClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TileButton clicked = (TileButton) e.getSource();
            if (clicked.isMatched() || clicked.isShowingValue()) return;

            clicked.showValue();
            SoundUtils.playSound("sounds/click.wav");

            if (firstSelected == null) {
                firstSelected = clicked;
            } else if (secondSelected == null && clicked != firstSelected) {
                secondSelected = clicked;
                if (onMove != null) onMove.run();

                if (firstSelected.getValue() == secondSelected.getValue()) {
                    SoundUtils.playSound("sounds/success.wav");
                    firstSelected.setMatched(true);
                    secondSelected.setMatched(true);
                    firstSelected = null;
                    secondSelected = null;
                    matchedPairs++;
                    if (matchedPairs == totalPairs && onWin != null) {
                        onWin.run();
                    }
                } else {
                    SoundUtils.playSound("sounds/error.wav");
                    flipBackTimer.start();
                }
            }
        }
    }
}
