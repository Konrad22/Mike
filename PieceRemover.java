import java.awt.*;

public class PieceRemover
{
	int counter_red = 0;
	int counter_blue = 7;
	GamePiece taken [] = new GamePiece[13];


  void takePiece(Graphics graphics, GamePiece gamePiece, Player player)
	{
		gamePiece.erase(graphics);
		if(TurnCounter.black())
		{
			graphics.setColor(FrameBuilder.BLUE_PLAYER);
			taken[counter_red].draw(graphics);
			counter_red++;
		}
		else
		{
			graphics.setColor(FrameBuilder.RED_PLAYER);
			taken[counter_blue].draw(graphics);
			counter_blue++;
		}
		player.removePieceFromList(gamePiece);

	}
}