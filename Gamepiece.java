public class Gamepiece
{
	int x, y, r, c;				//c....color
	Gamepiece(int newX, int newY, int newR)  //r...radian
	{
		x = newX;
		y = newY;
		r = newR;
		c = BackgroundColor;		//needs to be implemented somewhere
	}

	void draw()
	{
		g.drawOval(x - r, y - r, 2*r, 2*r);		//is that possible? g would be the frame, I think?
	}
	
	void erase()
	{
		this.c = BackgroundColor		//gotta implement it *somehow*
		//
	}
	
	void moveTo(int newX, int newY)
	{
		this.erase();
		x = newX;
		y = newy;
		this.draw();
	}
	
	
}
