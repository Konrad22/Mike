import java.awt.*;
import java.util.List;
import java.util.Collections;

public class GamePiece
{
	private List<GamePiece> listOfPiecesInReach;
	int x, y, radian;
	Color color;
	Player player;
	GamePiece(int x, int y, int radian, Player player)  //r...radian
	{
		this.x = x;
		this.y = y;
		this.radian = radian;
		this.player = player;
		color = FrameBuilder.BACKGROUND_COLOR; //ask later
	}
	
	GamePiece(int x, int y, int radian, Color color, Player player)  //r...radian
	{
		this.x = x;
		this.y = y;
		this.radian = radian;
		this.player = player;
		listOfPiecesInReach = Collections.emptyList();
	}

	void addNeighbours(List<GamePiece> listOfPiecesInReach)
	{
		this.listOfPiecesInReach = listOfPiecesInReach;
	}
	void draw(Graphics graphics)
	{
		graphics.fillOval(x - radian, y - radian, 2* radian, 2* radian);		//is that possible? g would be the frame, I think?
	}
	
	void erase(Graphics graphics)
	{
		color = FrameBuilder.BACKGROUND_COLOR;				//need to replace this once I pick the color
		graphics.setColor(color);
		draw(graphics);
	}

	void moveTo(GamePiece gamePiece, Graphics graphics)
	{
		Color color = this.color;
		erase(graphics);
		graphics.setColor(color);
		gamePiece.draw(graphics);
		player.updateListOfPieces(this, gamePiece);
	}
}

//probably will have to extend something somewhere to include coloring
