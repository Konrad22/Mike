import java.awt.*;
import java.util.List;

public class Player
{
	Color color;
	List<GamePiece> listOfPieces;
	Stage stage;
	
	Player(Color color)
	{
		this.color = color;
		stage = Stage.STAGE1;
	}

	private enum Stage
	{
		STAGE1, STAGE2, STAGE3;
	}
	
	public void changePhase(Stage stage)
	{
		this.stage = stage;
	}
	
	public Stage checkStage()
	{
		return this.stage;
	}
	
	public int checkNumberOfPieces()
	{
		return this.listOfPieces.size();
	}
	
	public void updateListOfPieces(GamePiece g1, GamePiece g2)
	{
		listOfPieces.remove(g1);
		listOfPieces.add(g2);
	}
	
	public void removePieceFromList(GamePiece g)
	{
		listOfPieces.remove(g);
	}
}
