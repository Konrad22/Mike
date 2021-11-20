import java.awt.*;

import static java.awt.Color.BLACK;

public class BoardMarker
{
	int x, y, radian;
	private boolean free = true;
	Graphics graphics;
	
	BoardMarker(int x, int y, int radian, Graphics graphics)
	{
		this.x = x;
		this.y = y;
		this.radian = radian;
		this.graphics = graphics;
	}
	
	private void draw()
	{
		graphics.setColor(BLACK);
		graphics.fillOval(x - radian, y - radian, 2*radian, 2*radian);		//is that possible? g would be the frame, I think?
	}
	
	void occupy()
	{
		free = false;
	}
	
	void leave()
	{
		free = true;
		this.draw();
	}
}
