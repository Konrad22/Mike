import java.awt.*;

public class ClickInterceptor extends Panel
{
    int x, y, radian;

    ClickInterceptor(int x, int y, int radian)
    {
        this.x = x;
        this.y = y;
        this.radian = radian;
        this.setBounds(this.x, this.y, this.radian, this.radian);
    }

    public void printCoordinates()
    {
        System.out.println("x:" + x + ", y:" + y);
    }
}
