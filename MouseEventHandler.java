import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventHandler implements MouseListener
{
    GamePiece gamePiece;

    public MouseEventHandler(GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        //gamePiece.printCoordinates();
        gamePiece.handleMouseClicks();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //not needed
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //not needed
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //not needed
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //not needed
    }
}
