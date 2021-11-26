import java.awt.*;

public class GameBoardDrawer extends Component
{
    static int x = 200;
    static int y = 200;
    static int s = 100;
    Font font = new Font("Arial", Font.PLAIN, 32);
    public GameBoardDrawer()
    {
        this.setBounds(0, 0, 1000, 1000);
    }

    @Override
    public void paint(Graphics graphics)
    {
        drawGameBoard(graphics);
    }

    void drawGameBoard(Graphics graphics)
    {
        graphics.setColor(Game.LINE_COLOR);
        graphics.drawRect(x, y, 6 * s, 6 * s);
        graphics.drawRect(x + s, y + s, 4 * s, 4 * s);
        graphics.drawRect(x + 2 * s, y + 2 * s, 2 * s, 2 * s);
        graphics.drawLine(x + 3 * s, y, x + 3 * s, y + 2 * s);
        graphics.drawLine(x + 3 * s, y + 4 * s, x + 3 * s, y + 6 * s);
        graphics.drawLine(x, y + 3 * s, x + 2 * s, y + 3 * s);
        graphics.drawLine(x + 4 * s, y + 3 * s, x + 6 * s, y + 3 * s);
    }

    void announceWinner(String nameOfWinner)
    {
        Graphics graphics = getGraphics();
        graphics.setFont(font);
        graphics.drawString(nameOfWinner + " wins", 20, 80);
    }
}
