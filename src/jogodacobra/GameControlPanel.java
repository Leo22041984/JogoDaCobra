package jogodacobra;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControlPanel extends JPanel {
    private JButton restartButton;
    private GamePanel gamePanel;

    public GameControlPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        restartButton = new JButton("Reiniciar");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.restartGame(); // Chame um método para reiniciar o jogo
            }
        });

        add(restartButton);
    }
}
