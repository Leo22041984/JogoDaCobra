
package jogodacobra;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // Adicione lógica para controlar a cobra com as teclas aqui
        if (key == KeyEvent.VK_UP) {
            // Defina a direção da cobra para cima
        } else if (key == KeyEvent.VK_DOWN) {
            // Defina a direção da cobra para baixo
        } else if (key == KeyEvent.VK_LEFT) {
            // Defina a direção da cobra para a esquerda
        } else if (key == KeyEvent.VK_RIGHT) {
            // Defina a direção da cobra para a direita
        }
    }
}
