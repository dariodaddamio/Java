public class Dice 
{
	private int rolls;
	private int sum;
	private double percentage;
	private int[] board;
	public Dice(int sum, int value, int[] board)
	{
		this.sum = sum;
		this.rolls = value;
		this.board = board;
	}
	//returns number of rolls desired
	public int getRolls(int value)
	{
		return rolls;
	}
	
	//returns the number of results acquired for each sum (spot)
	public int getTotal(int spot)
	{
		return board[spot];
	}
	
	//returns percentage per each sum
	public double getPercentage(int spot)
	{
		percentage = (0.0 + board[spot])/rolls*100.0;
		return percentage;
	}
	
	//creates and returns asterisks quantity for bell curve per asterisks value (1,10, etc.)
	public String getAsterisks(int spot, int scale)
	{
		String ans = "";
		for(int i = 0; i < board[spot]/scale; i++)
		{
			ans = ans + "*";
		}
		return ans;
	}
	//updates number of results for each sum
	public void updateArray(int sum)
	{
		for(int i = 2; i < board.length; i++)
		{
			if(sum == i)
				{
					board[i]++;
				}
		}
	}
}
