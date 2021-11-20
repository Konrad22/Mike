public class Player
{
	Color c;
	ArrayList<Gamepiece> listOfPieces = new ArrayList<>();
	Stage stage;
	
	Player(Color newC)
	{
		c = ColorState.newC;
		stage = STAGE1;
	}

	private enum Stage
	{
		STAGE1, STAGE2, STAGE3;
	}
	
	public void changePhase(Stage newStage)
	{
		this.stage = newStage
	}
	
	public Stage checkStage()
	{
		return this.stage;
	}
	
	public int checkNumberOfPieces()
	{
		return this.listOfPieces.size();
	}
	
	public void updateListOfPieces(Gamepiece g1, Gamepiece g2)
	{
		listOfPieces.remove(g1);
		listOfPieces.add(g2);
	}
	
	public void removePieceFromList(Gamepiece g)
	{
		listOfPieces.remove(g);
	}
}
