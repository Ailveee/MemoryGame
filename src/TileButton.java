import javax.swing.*;

public class TileButton extends JButton {
    private final int value;
    private boolean matched = false;
    private boolean showingValue = false;

    public TileButton(int value) {
        this.value = value;
        hideValue();
        setFont(getFont().deriveFont(24f));
    }

    public int getValue() {
        return value;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
        if (matched) setEnabled(false);
    }

    public boolean isShowingValue() {
        return showingValue;
    }

    public void showValue() {
        setText(String.valueOf(value));
        showingValue = true;
    }

    public void hideValue() {
        setText("");
        showingValue = false;
    }
}
