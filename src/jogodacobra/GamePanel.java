// GamePanel.java
package jogodacobra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private int screenWidth;
    private int screenHeight;
    private Timer timer;
    private Snake snake;
    private Food food;
    private Score score;
    private boolean isGameOver = false;

    public GamePanel() {
        screenWidth = 400;
        screenHeight = 400;
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        timer = new Timer(100, this);
        timer.start();

        food = new Food(screenWidth, screenHeight);
        score = new Score();
        snake = new Snake(screenWidth, screenHeight, food, score);

        // Crie um botão de reiniciar e adicione-o ao painel principal
        JButton restartButton = new JButton("Reiniciar");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        // Use um layout para posicionar o botão na parte inferior
        setLayout(new BorderLayout());
        add(restartButton, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    snake.move();
    if (snake.checkCollision(food.getPosition())) {
        snake.grow();
        
        score.increaseScore();
    }

    if (snake.checkBoundaryCollision()) {
        // Implemente a lógica de fim de jogo aqui
        timer.stop();
        // Exibir mensagem de fim de jogo ou reiniciar o jogo
        restartGame(); // Reinicie o jogo
    }

    repaint();
}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
        food.draw(g);
        score.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP && snake.getDirection() != Snake.Direction.DOWN) {
            snake.setDirection(Snake.Direction.UP);
        } else if (key == KeyEvent.VK_DOWN && snake.getDirection() != Snake.Direction.UP) {
            snake.setDirection(Snake.Direction.DOWN);
        } else if (key == KeyEvent.VK_LEFT && snake.getDirection() != Snake.Direction.RIGHT) {
            snake.setDirection(Snake.Direction.LEFT);
        } else if (key == KeyEvent.VK_RIGHT && snake.getDirection() != Snake.Direction.LEFT) {
            snake.setDirection(Snake.Direction.RIGHT);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void restartGame() {
    // Implemente a lógica de reinicialização aqui, por exemplo:
    snake.resetDirection();
    isGameOver = false;
    score.resetScore();
    snake.resetSnake(); // Isso reinicia a cobra para a posição inicial
    food.generateNewPosition(); // Isso gera uma nova posição para a comida
    timer.start();
    requestFocus();
}


    

}
