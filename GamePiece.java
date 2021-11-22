import java.awt.*;
import java.util.List;
import java.util.Collections;

public class GamePiece
{
	private List<GamePiece> listOfPiecesInReach;
	int x, y, radian;
	Color color;
	Player player;
	ClickInterceptor clickInterceptor;

	GamePiece(int x, int y, int radian)
	{
		this.x = x - radian/2;
		this.y = y - radian/2;
		this.radian = radian;
		color = FrameBuilder.BACKGROUND_COLOR;
		clickInterceptor = new ClickInterceptor(this.x, this.y, this.radian);
		MouseEventHandler handler = new MouseEventHandler(clickInterceptor);
		clickInterceptor.addMouseListener(handler);
	}
	
	GamePiece(int x, int y, int radian, Player player)
	{
		this.x = x - radian/2;
		this.y = y - radian/2;
		this.radian = radian;
		this.player = player;
		color = player.color;
		listOfPiecesInReach = Collections.emptyList();
	}

	void addNeighbours(List<GamePiece> listOfPiecesInReach)
	{
		this.listOfPiecesInReach = listOfPiecesInReach;
	}

	void draw(Graphics graphics)
	{
		graphics.setColor(color);
		graphics.fillOval(x, y, radian, radian);
	}
	
	void erase(Graphics graphics)
	{
		color = FrameBuilder.BACKGROUND_COLOR;
		draw(graphics);
	}

	void moveTo(GamePiece gamePiece, Graphics graphics)
	{
		gamePiece.color = color;
		erase(graphics);
		gamePiece.draw(graphics);
		player.updateListOfPieces(this, gamePiece);
	}

	void selectGamePiece(Graphics graphics)
	{
		graphics.setColor(FrameBuilder.LINE_COLOR);
		graphics.drawOval(x, y, radian, radian);
	}

	void deselectGamePiece(Graphics graphics)
	{
		draw(graphics);
	}

	void addMouseListener(MouseEventHandler mouseEventHandler)
	{
		//?
	}
}