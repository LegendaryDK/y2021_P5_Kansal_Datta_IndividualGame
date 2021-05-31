import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Score extends Text {
    private int score;
    private List<ScoreListener> scoreListeners;

    public Score() {
        score = 0;
        this.setFont(Font.font(20));
        updateDisplay();
        scoreListeners = new ArrayList<>();
    }

    public void updateDisplay() {
        this.setText(String.valueOf(score));
    }

    public int getScoreCount() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScoreListener(ScoreListener l) {
        if (!scoreListeners.contains(l)) scoreListeners.add(l);
    }

    public void removeScoreListener(ScoreListener l) {
        scoreListeners.remove(l);
    }
}
