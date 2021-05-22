import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Score extends Text {
    private int score;

    public Score(){
        score = 0;
        this.setFont(Font.font(20));
        updateDisplay();
    }


    public void updateDisplay(){
        this.setText(String.valueOf(score));
    }

    public int getScoreCount() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
