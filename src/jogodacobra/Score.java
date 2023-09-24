
package jogodacobra;

import java.awt.*;

public class Score {
    private int score;

    public Score() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }
    
    public void resetScore() {
    score = 0;
}

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Pontuação: " + score, 10, 30);
    }
}
