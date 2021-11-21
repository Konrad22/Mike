import java.awt.*;
import java.util.List; //frankly I have no idea when to use static/private/public, so this stuff probably doesn't make sense

public class GameBoardDrawer extends Component
{
    static int x = 200;
    static int y = 200;
    static int s = 100;
    List<GamePiece> gamePieceList;
    List<BoardMarker> boardMarkerList;

    public GameBoardDrawer(List<GamePiece> gamePieceList, List<BoardMarker> boardMarkerList)
    {
        this.gamePieceList = gamePieceList;
        this.boardMarkerList = boardMarkerList;
    }

    @Override
    public void paint(Graphics graphics)
    {
        drawGameBoard(graphics);
        for (GamePiece gamePiece : gamePieceList) {
            graphics.setColor(gamePiece.color);
            gamePiece.draw(graphics);
        }

        for (BoardMarker boardMarker : boardMarkerList) {
            boardMarker.draw(graphics);
        }
    }

    void drawGameBoard(Graphics graphics)
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
