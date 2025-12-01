package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import main.Game;
import main.GameStates;
import ui.MyButton;

/**
 * Cena de Vitória
 * Mostra mensagem de parabéns e um botão para voltar ao menu e jogar novamente.
 * A música de vitória é disparada pela cena Playing quando a condição de vitória é alcançada.
 */
public class Victory extends GameScene implements SceneMethods {
    private MyButton bMenu;

    public Victory(Game game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
        int w = 220;
        int h = 60;
        int x = 320 - w / 2; // centralizado horizontalmente
        int y = 420 - h / 2; // levemente abaixo do centro

        this.bMenu = new MyButton("Menu", x, y, w, h);
    }

    @Override
    public void render(Graphics g) {
        // Fundo igual ao Menu/GameOver
        g.setColor(new Color(15, 15, 25));
        g.fillRect(0, 0, 640, 800);

        // Título principal "Tower Defense" (mesmo estilo do Menu)
        g.setColor(new Color(230, 230, 230));
        g.setFont(new Font("LucidaSans", Font.BOLD, 40));
        String title = "Tower Defense";
        int titleWidth = g.getFontMetrics().stringWidth(title);
        g.drawString(title, 320 - titleWidth / 2, 120);

        // Mensagem de vitória
        g.setFont(new Font("LucidaSans", Font.BOLD, 32));
        String victoryText = "Você venceu!";
        int vWidth = g.getFontMetrics().stringWidth(victoryText);
        g.drawString(victoryText, 320 - vWidth / 2, 200);

        // Subtexto opcional
        g.setFont(new Font("LucidaSans", Font.PLAIN, 18));
        String sub = "Todas as waves foram concluídas.";
        int sWidth = g.getFontMetrics().stringWidth(sub);
        g.drawString(sub, 320 - sWidth / 2, 240);

        // Botão para voltar ao menu
        drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        this.bMenu.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (this.bMenu.getBounds().contains(x, y)) {
            // Volta ao menu e prepara um novo jogo
            this.game.resetPlaying();
            GameStates.SetGameState(GameStates.MENU);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        this.bMenu.setMouseOver(this.bMenu.getBounds().contains(x, y));
    }

    @Override
    public void mousePressed(int x, int y) {
        if (this.bMenu.getBounds().contains(x, y)) {
            this.bMenu.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        this.bMenu.resetBooleans();
    }

    @Override
    public void mouseDragged(int x, int y) {
        // Nenhum comportamento especial para arrastar na tela de vitória
    }
}
