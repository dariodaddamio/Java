public class MouseOnIslandTest
{
	public static void main(String[] args)
	{
		//new(s) method(s)
		EasyReader kb = new EasyReader();
		
		//simulation prompt(s)
		System.out.println("Insert the height of the island (rows):");
		int rows = kb.readInt();
		System.out.println("Insert the width of the island (columns):");
		int columns = kb.readInt();
		System.out.println("Insert the percentage (%) of bridges:");
		int bpercent = kb.readInt();
		System.out.println("Insert the max number of moves:");
		int maxmoves = kb.readInt();
		if(maxmoves == 0)
		{
			System.out.println("Please insert a number greater than 0: ");
			maxmoves = kb.readInt();
		}
		System.out.println("Insert the number of simulations:");
		int sims = kb.readInt();
		
		int[][] island = new int[rows][columns];
		
		//mouse starting position
				int mRow = rows/2;
				int mCol = columns/2;
				
		MouseOnIsland sim = new MouseOnIsland(island, mRow, mCol);
		
		//running simulations
		int escaped = 0;
		int starved = 0;
		int drowned = 0;
			for(int i = 0; i < sims; i++)
				{
					sim.generateIsland(rows, columns, bpercent);
					for(int j = 0; j < maxmoves; j++)
					{
						sim.moveAbout(rows, columns, maxmoves);
						
						if(sim.escapeStatus() == true)
						{
							System.out.println("The mouse escaped.");
							j = maxmoves;
							escaped++;
						}
						else if(sim.starveStatus() == true)
						{
							System.out.println("The mouse starved.");
							j = maxmoves;
							starved++;
						}
						else if(sim.drownStatus() == true)
						{
							System.out.println("The mouse drowned.");
							j = maxmoves;
							drowned++;
						}
					}
					System.out.println(sim.printIsland(rows, columns, bpercent));
					sim.resetSim(rows,columns);
				}
			System.out.println("In " + sims + " simulations the mouse...");
			System.out.println("escaped "+  EasyFormat.format(sim.getPEsc(escaped, sims),3, 2) + "% of the time (" + sim.getPEsc(escaped, sims)/100 * sims + ")");
			System.out.println("starved " + EasyFormat.format(sim.getPSta(starved, sims),3, 2) + "% of the time (" + sim.getPSta(starved, sims)/100 * sims + ")");
			System.out.println("drowned " + EasyFormat.format(sim.getPDro(drowned, sims),3, 2) + "% of the time (" + sim.getPDro(drowned, sims)/100 * sims + ")");
	}
}