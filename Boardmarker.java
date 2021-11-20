public class BoardMarker
{
	int x, y, r;
	private boolean FREE = true;
	
	BoardMarker(int newX, int newY, int newR)
	{
		x = newX;
		y = newY;
		r = newR;
	}
	
	void draw()
	{
		g.drawOval(x - r, y - r, 2*r, 2*r, ColorState.BLACK);		//is that possible? g would be the frame, I think?
	}
	
	void occupy()
	{
		FREE = false;
	}
	
	void leave()
	{
		FREE = true;
		this.draw()
	}
}
