public class Gamepiece
{
	int x, y, r;	
	Color c;					//c....color
	Gamepiece(int newX, int newY, int newR, Frame f)  //r...radian
	{
		x = newX;
		y = newY;
		r = newR;
		c = BackgroundColor;		//needs to be implemented somewhere
		f.this.draw()
	}
	
	Gamepiece(int newX, int newY, int newR, Color newC, Frame f)  //r...radian
	{
		x = newX;
		y = newY;
		r = newR;
		c = newC;		//needs to be implemented somewhere
		f.this.draw()
	}
	
	void draw()
	{
		this.fillOval(x - r, y - r, 2*r, 2*r, BackgroundColor);		//is that possible? g would be the frame, I think?
	}

	void draw(int newC)
	{
		this.fillOval(x - r, y - r, 2*r, 2*r, newC);		//is that possible? g would be the frame, I think?
	}
	
	void erase(Gamepiece g)
	{
		g.c = BackgroundColor;		//gotta implement it *somehow*
	}
	
	void moveTo(int newX, int newY)
	{
		this.erase();
		this.x = newX;
		this.y = newy;
		this.draw();
	}
	public Color c()
	{
		return c;
	}
	
	public int x()
	{
		return x;
	}
	
	public int y()
	{
		return y;
	}	
	
}

//probably will have to extend something somewhere to include coloring
