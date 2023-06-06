import java.util.Random;

public class DiceTest 
{
	public static void main(String[] args)
	{
		EasyReader kb = new EasyReader();
		Random generate = new Random();
		
		//prompt user for sides of dice
		System.out.println("Input the number of sides of the dice desired:");
		int sides = kb.readInt();
		int[] board = new int[sides*2+1];
		
		//prompt user for rolls desired
		System.out.println("Input the number of rolls desired:");
		int value = kb.readInt(); //value is rolls desired
		
		//prompt user for scale
		System.out.println("Input the desired equivalent of 1 asterisk for the graph:");
		int scale = kb.readInt();
		
		//dice roll simulator & sum declare
		int die1 = generate.nextInt(sides)+1;
		int die2 = generate.nextInt(sides)+1;
		int sum = die1 + die2;
		Dice dice = new Dice(sum, value, board);
		
		//dice rolls for "value" rolls & updater
		for(int i = 1; i <= value; i++) //i is toss number
			{
				dice.updateArray(sum);
				die1 = generate.nextInt(sides)+1;
				die2 = generate.nextInt(sides)+1;
				sum = die1 + die2;
			}
		System.out.println(EasyFormat.format("Sum",0) + EasyFormat.format("Total",7) + EasyFormat.format("Graph (1 astrisks = " + scale + "%)", 30) + EasyFormat.format("Percentages", 20));
		for(int i = 2; i <= sides*2; i++)
			{	
				System.out.println(EasyFormat.format(i,2) + EasyFormat.format(dice.getTotal(i), 7) + EasyFormat.format(dice.getAsterisks(i, scale), 30,'L', 6) + EasyFormat.format(dice.getPercentage(i),9,2) + "%");
			}
		}
}
