import java.awt.*;
import java.util.List;
import java.util.Collections;

public class GamePiece extends Component
{
	private List<GamePiece> listOfPiecesInReach;
	int x, y, radian;
	Color color;
	Player player;

	GamePiece(int x, int y, int radian)
	{
		this.x = x - radian/2;
		this.y = y - radian/2;
		this.radian = radian;
		color = Game.BACKGROUND_COLOR;
		MouseEventHandler handler = new MouseEventHandler(this);
		this.addMouseListener(handler);
		this.setBounds(this.x, this.y, this.radian, this.radian);
	}
	
	GamePiece(int x, int y, int radian, Player player)
	{
		this.x = x - radian/2;
		this.y = y - radian/2;
		this.radian = radian;
		this.player = player;
		color = player.color;
		listOfPiecesInReach = Collections.emptyList();
		this.setBounds(this.x, this.y, this.radian, this.radian);
	}

	void addNeighbours(List<GamePiece> listOfPiecesInReach)
	{
		this.listOfPiecesInReach = listOfPiecesInReach;
	}

	void handleMouseClicks()
	{
		if(player == null && Game.INSTANCE.stage == Game.Stage.PLACE_PIECE)
		{
			changeColor();
			draw();
			player = Game.INSTANCE.currentPlayer;
		}
		if(player != null && player != Game.INSTANCE.currentPlayer && Game.INSTANCE.stage == Game.Stage.REMOVE_ENEMY_PIECE)
		{
			color = Game.BACKGROUND_COLOR;
			draw();
			player = null;
		}
		Game.INSTANCE.endTurn(this);
	}

	void draw()
	{
		Graphics graphics = getGraphics();
		graphics.setColor(color);
		graphics.fillOval(0, 0, radian, radian);
	}

	void changeColor()
	{
		color = Game.INSTANCE.currentPlayer.color;
	}
	
	void erase()
	{
		color = Game.BACKGROUND_COLOR;
		draw();
	}

	@Override
	public void paint(Graphics graphics)
	{
		if(player == null)
		{
			graphics.setColor(color);
			graphics.fillOval(0, 0, radian, radian);
			graphics.setColor(Game.LINE_COLOR);
			graphics.fillOval(radian/4, radian/4, radian/2, radian/2);
		}
		else
		{
			graphics.setColor(color);
			graphics.fillOval(0, 0, radian, radian);
		}

	}

	public void printCoordinates()
	{
		System.out.println("x, y: " + x + ", " + y);
	}

	void moveTo(GamePiece gamePiece, Graphics graphics)
	{
		gamePiece.color = color;
		erase();
		gamePiece.draw();
	}

	void selectGamePiece(Graphics graphics)
	{
		graphics.setColor(Game.LINE_COLOR);
		graphics.drawOval(x, y, radian, radian);
	}

	void deselectGamePiece(Graphics graphics)
	{
		draw();
	}
}