// Snake.java
package jogodacobra;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> segments;
    private Direction direction;
    private Food food;
    private int screenWidth;
    private int screenHeight;
    private static final int segmentSize = 10;
    private boolean isAlive;
    private Score score;
    private boolean isGrowing; // Adicione uma variável para controlar o crescimento da cobra
    
    
    public Snake(int screenWidth, int screenHeight, Food food, Score score) {
    this.screenWidth = screenWidth;
    this.screenHeight = screenHeight;
    this.food = food;
    this.score = score; // Atribua a instância de Score passada como parâmetro
    segments = new LinkedList<>();
    segments.add(new Point(5, 5));
    direction = Direction.RIGHT;
    isAlive = true;
    score.resetScore(); // Certifique-se de redefinir a pontuação ao iniciar o jogo
}

    

    public void move() {
    if (!isAlive) {
        return; // Se a cobra estiver morta, não faça nada
    }

    Point newHead = calculateNewHead();

    if (checkBoundaryCollision() || checkSelfCollision(newHead)) {
        isAlive = false; // A cobra morreu
        return;
    }

    segments.addFirst(newHead);

    if (checkCollision(food.getPosition())) {
        food.generateNewPosition();
        score.increaseScore();
    } else {
        // Não remova o último segmento se a cobra não comer a comida
        segments.removeLast();
    }
}
   
   public void resetDirection() {
    direction = Direction.RIGHT; // ou a direção padrão desejada após reiniciar
}



    public void grow() {
        // O crescimento agora é tratado no método `move`
    }

    public boolean checkCollision(Point foodPosition) {
    Point head = segments.getFirst();
    // Verifique se a cabeça da cobra está na mesma posição que a comida
    return head.equals(new Point(foodPosition.x / segmentSize, foodPosition.y / segmentSize));
}


    public boolean checkBoundaryCollision() {
        Point head = segments.getFirst();
        int x = head.x;
        int y = head.y;
        return x < 0 || x >= screenWidth || y < 0 || y >= screenHeight;
    }

    public boolean checkSelfCollision(Point newHead) {
        for (Point segment : segments) {
            if (newHead.equals(segment)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics g) {
        for (Point segment : segments) {
            g.setColor(Color.GREEN);
            g.fillRect(segment.x * segmentSize, segment.y * segmentSize, segmentSize, segmentSize);
        }
    }

    public Point getHead() {
        return segments.getFirst();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private Point calculateNewHead() {
        Point head = segments.getFirst();
        int x = head.x;
        int y = head.y;

        if (direction == Direction.UP) {
            y--;
        } else if (direction == Direction.DOWN) {
            y++;
        } else if (direction == Direction.LEFT) {
            x--;
        } else if (direction == Direction.RIGHT) {
            x++;
        }

        return new Point(x, y);
    }

    public void resetSnake() {
    segments.clear(); // Limpa todos os segmentos da cobra
    segments.add(new Point(5, 5)); // Adiciona um novo segmento na posição inicial
    direction = Direction.RIGHT; // Define a direção inicial
}

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
