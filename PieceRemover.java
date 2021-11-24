import java.awt.*;

public class PieceRemover
{
	int counter_red = 0;
	int counter_blue = 7;
	GamePiece taken [] = new GamePiece[13];


  void takePiece(GamePiece gamePiece, Player player)
	{
		gamePiece.erase();
		if(TurnCounter.black())
		{
			taken[counter_red].draw();
			counter_red++;
		}
		else
		{
			taken[counter_blue].draw();
			counter_blue++;
		}
	}
}