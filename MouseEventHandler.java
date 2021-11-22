import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventHandler implements MouseListener
{
    ClickInterceptor interceptor;

    public MouseEventHandler(ClickInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        interceptor.printCoordinates();
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
