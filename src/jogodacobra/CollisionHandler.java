
// CollisionHandler.java
package jogodacobra;

import java.awt.Point;

public class CollisionHandler {
    public boolean checkCollision(Snake snake, Food food) {
        Point head = snake.getHead();
        Point foodPosition = food.getPosition();
        return head.equals(foodPosition);
    }

    public boolean checkBoundaryCollision(Snake snake, int screenWidth, int screenHeight) {
        Point head = snake.getHead();
        int x = head.x;
        int y = head.y;
        return x < 0 || x >= screenWidth || y < 0 || y >= screenHeight;
    }

    public boolean checkSelfCollision(Snake snake) {
        // Você não precisa mais verificar a colisão com os segmentos da cobra aqui
        // Pois a classe Snake já cuida disso
        return false;
    }
}
