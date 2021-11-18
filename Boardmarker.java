public class BoardMarker
{
	int x, y, r; //u...in use?
	static int FREE = 0;
	static int BLOCKED = 1;
	
	BoardMarker(int newX, int newY, int newR)
	{
		x = newX;
		y = newY;
		r = newR;
	}
	
	void draw()
	{
		g.drawOval(x - r, y - r, 2*r, 2*r);		//is that possible? g would be the frame, I think?
	}
	
	void occupy()
	{
		this.u = BLOCKED;
	}
	
	void leave()
	{
		this.u = FREE;
	}
}
