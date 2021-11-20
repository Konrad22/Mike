public class Player
{
	Color c;
	int pieces;
	Stage stage;
	
	Player(Color newC)
	{
		c = ColorState.newC;
		pieces = 9;
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
}
