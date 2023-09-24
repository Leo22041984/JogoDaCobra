// Food.java
package jogodacobra;

import java.awt.*;
import java.util.Random;

public class Food {
    private Point position;
    private int screenWidth;
    private int screenHeight;

    public Food(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        generateNewPosition();
    }

    public Point getPosition() {
        return position;
    }

    public void generateNewPosition() {
    Random random = new Random();
    int x = random.nextInt(screenWidth / 10) * 10;
    int y = random.nextInt(screenHeight / 10) * 10;
    position = new Point(x, y);
}

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(position.x, position.y, 10, 10);
    }
}
