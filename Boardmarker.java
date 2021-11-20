public class BoardMarker
{
	int x, y, r;
	private boolean free = true;
	
	BoardMarker(int newX, int newY, int newR)
	{
		x = newX;
		y = newY;
		r = newR;
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
