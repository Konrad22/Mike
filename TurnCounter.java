public class TurnCounter
{
	private static boolean isTurnBlack = false;		//I probably still need a constructor for this to call the method, right?
	
	TurnCounter()														//Technically, this would construct a TurnCounter with isTurnBlack == false ?
	{
	}
	
	public void changeTurn()
 	{
		isTurnBlack = !isTurnBlack;
	}
	
	public static boolean black()
	{
		return isTurnBlack;
	}
}
