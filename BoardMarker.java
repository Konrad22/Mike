import java.awt.*;

import static java.awt.Color.BLACK;

public class BoardMarker
{
	int x, y, radian;
	private boolean free = true;
	
	BoardMarker(int x, int y, int radian)
	{
		this.x = x - radian/2;
		this.y = y - radian/2;
		this.radian = radian;
	}
	
	void draw(Graphics graphics)
	{
		graphics.setColor(BLACK);
		graphics.fillOval(x, y, radian, radian);
	}
	
	void occupy()
	{
		free = false;
	}
	
	void leave(Graphics graphics)
	{
		free = true;
		this.draw(graphics);
	}
}
