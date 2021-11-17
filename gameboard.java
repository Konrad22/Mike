import java.awt.*;

static int WHITE = 0;
static int BLACK = 1;
static int BACKGROUND = 2;

public class BoardMarker
{
	int x, y, r, u; //u...in use?
	static int FREE = 0;
	static int BLOCKED = 1;
	
	BoardMarker(int newX, int newY, int newR)
	{
		x = newX;
		y = newY;
		r = newR;
		u = FREE;
	}
	
	void draw()
	{
		g.drawOval(x - r, y - r, 2*r, 2*r);		//geht das? g wäre das Frame quasi
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


public class Stone
{
	int x, y, r, i;
	static int NOTINGAME = 0;
	static int INGAME = 1;
	Stone(int NewX, int newY, int newR)
	{
		x = newX;
		y = newY;
		r = newR;
		i = NOTINGAME;
	}

	void draw()
	{
		g.drawOval(x - r, y - r, 2*r, 2*r);		//geht das? g wäre das Frame quasi
	}
	
	void erase()
	{
		this.erase()		//jep, das muss ich irgendwie hinbekommen
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


public class gameboard
{
	static void DrawGameboard(int x, int y, int z, int d1, int e1) //s == 6*z, z muss durch 6 teilbar sein
	{
		int s = z/6  sixth
		int d = z/(2*d1)
		int e = z/(2*e1)
		
		
	}
	
	public void Draw(Graphics g)
	{
		g.drawRect(x      , y      , 6*s, 6*s)
		g.drawRect(x + s  , y +   s, 4*s, 4*s)
		g.drawRect(x + 2*s, y + 2*s, 2*s, 2*s)
		g.drawLine(x + 3*s, y      , x + 3*s, y + 2*s)
		g.drawLine(x + 3*s, y + 4*s, x + 3*s, y + 6*s)
		g.drawLine(x      , y + 3*s, x + 2*s, y + 3*s)
		g.drawLine(x + 4*s, y + 3*s, x + 6*s, y + 3*s)
		g.drawOval(x - d      , y - d      , 2*d, 2*d) //Spielmarkierungen vielleicht als Objekte anlegen, damit sie Status belegt/unbelegt haben?
		g.drawOval(x - d + 6*s, y - d      , 2*d, 2*d)
		g.drawOval(x - d +   s, y - d +   s, 2*d, 2*d)
		g.drawOval(x - d + 3*s, y - d +   s, 2*d, 2*d)
		g.drawOval(x - d + 5*s, y - d +   s, 2*d, 2*d)
		g.drawOval(x - d + 2*s, y - d + 2*s, 2*d, 2*d)
		g.drawOval(x - d + 3*s, y - d + 2*s, 2*d, 2*d)
		g.drawOval(x - d + 4*s, y - d + 2*s, 2*d, 2*d) //bis hier gemacht, muss noch weiter vervollständigt werden, 24 insgesamt
		.
		.
		.
	}
	
	static void MoveStone(stone s, int x, int y)	//Klasse stone muss noch erstellt werden, Methoden erase, move, draw,
													//x, y sind Zielkoordinaten
	{
		a = stone.x - x
		b = stone.y - y
		s.erase()
		s.move(a, b) //stone.x =+ a, stone.y =+ b
		s.draw()
	}
	public static void main(String args[])
	{
		
	}
}