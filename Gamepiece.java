public class Gamepiece
{
	private ArrayList<Gamepiece> listOfPiecesInReach = new ArrayList<>();
	int x, y, r;	
	Color c;
	Player p;
	Gamepiece(int newX, int newY, int newR, Player newP, ArrayList<Gamepiece> newList)  //r...radian
	{
		x = newX;
		y = newY;
		r = newR;
		c = Backgroundcolor;                     //need to replace this once I pick the color
		p = newP;
		listOfPiecesInReach = newList;
		f.this.draw();
	}
	
	Gamepiece(int newX, int newY, int newR, Color newC, Player newP)  //r...radian
	{
		x = newX;
		y = newY;
		r = newR;
		c = newC;                     //need to replace this once I pick the color
		p = newP;
		listOfPiecesInReach = Collections.<Gamepiece>emptyList();
		f.this.draw();
	}
	
	void draw()
	{
		this.fillOval(x - r, y - r, 2*r, 2*r, Backgroundcolor);		//is that possible? g would be the frame, I think?
										//need to replace it once I pick the color
	}

	void draw(Color c)
	{
		this.fillOval(x - r, y - r, 2*r, 2*r, c);		//is that possible? g would be the frame, I think?
	}
	
	void erase(Gamepiece g)
	{
		g.c = Backgroundcolor;		//need to replace this once I pick the color
	}
	
	void moveTo(Gamepiece g)
	{
		Colour color = this.color;
		this.erase();
		g.draw(color);
		p.updateListOfPieces(this, g);
	}
	public Color color()
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
