public class TurnCounter
{
	private static boolean isTurnRed = false;		//I probably still need a constructor for this to call the method, right?
	
	TurnCounter()														//Technically, this would construct a TurnCounter with isTurnBlack == false ?
	{
	}
	
	public void changeTurn()
 	{
		isTurnRed = !isTurnRed;
	}
	
	public static boolean black()
	{
		return isTurnRed;
	}
}
