import java.awt.*; //frankly I have no idea when to use static/private/public, so this stuff probably doesn't make sense

static int WHITE = 0;
static int BLACK = 1;
static int BACKGROUND = 2;

public class Gameboard
{
	static void DrawGameboard(int x, int y, int z, int d1, int e1) //s == 6*z, z has to be divisible by 6
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
		g.drawOval(x - d      , y - d      , 2*d, 2*d) //create markers as objects with Occupied/free attribute?
		g.drawOval(x - d + 6*s, y - d      , 2*d, 2*d)
		g.drawOval(x - d +   s, y - d +   s, 2*d, 2*d)
		g.drawOval(x - d + 3*s, y - d +   s, 2*d, 2*d)
		g.drawOval(x - d + 5*s, y - d +   s, 2*d, 2*d)
		g.drawOval(x - d + 2*s, y - d + 2*s, 2*d, 2*d)
		g.drawOval(x - d + 3*s, y - d + 2*s, 2*d, 2*d)
		g.drawOval(x - d + 4*s, y - d + 2*s, 2*d, 2*d) //finished only up here, but there have to be 24 over all
		.
		.
		.
	}
	
	static void MoveStone(stone s, int x, int y)	//class stone + methods erase, move, draw, x, y do not even exist yet...
													//x, y are the new coordinates
	{
		a = stone.x
		b = stone.y
		s.erase()
		//draw intersection (at a, b)
		s.move(x, y) //stone.x = x, stone.y = y
		s.draw()
	}
}
