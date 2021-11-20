import java.awt.*; //frankly I have no idea when to use static/private/public, so this stuff probably doesn't make sense

public class GameBoardDrawer extends Component
{
    @Override
    public void paint(Graphics graphics) {
        drawGameBoard(10, 10, 100, graphics);
    }

    void drawGameBoard(int x, int y, int s, Graphics graphics)
    {
        graphics.setColor(FrameBuilder.LINE_COLOR);
        graphics.drawRect(x, y, 6 * s, 6 * s);
        graphics.drawRect(x + s, y + s, 4 * s, 4 * s);
        graphics.drawRect(x + 2 * s, y + 2 * s, 2 * s, 2 * s);
        graphics.drawLine(x + 3 * s, y, x + 3 * s, y + 2 * s);
        graphics.drawLine(x + 3 * s, y + 4 * s, x + 3 * s, y + 6 * s);
        graphics.drawLine(x, y + 3 * s, x + 2 * s, y + 3 * s);
        graphics.drawLine(x + 4 * s, y + 3 * s, x + 6 * s, y + 3 * s);
    }
}
