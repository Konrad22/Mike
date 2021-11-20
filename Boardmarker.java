public class BoardMarker
{
	int x, y, radian;
	private boolean freeIntelliJ = true;
	
	BoardMarker(int newX, int newY, int newR)
	{
		x = newX;
		y = newY;
		radian = newR;
	}
	
	void draw()
	{
		g.drawOval(x - r, y - r, 2*r, 2*r, BLACK);		//is that possible? g would be the frame, I think?
	}
	
	void occupy()
	{
		free = false;
	}
	
	void leave()
	{
		free = true;
		this.draw()
	}
}
