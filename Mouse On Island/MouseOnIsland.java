import java.util.Random;

public class MouseOnIsland 
{
	Random generate = new Random();
	
	private int[][] island;
	private boolean drowned = false;
	private boolean starved = false;
	private boolean escaped = false;
	private int move;
	private int mRow;
	private int mCol;	
	private String ans = "";
	
	public MouseOnIsland(int[][] island, int mRow, int mCol)
	{
		this.island = island;
		this.mRow = mRow;
		this.mCol = mCol;
	}

	public void resetSim(int r, int c)
	{
		move = 0;
		ans = "";
		mRow = r/2;
		mCol = c/2;
		drowned = false;
		escaped = false;
		starved = false;
		island[mRow][mCol] = 1;
	}
	
	public void moveAbout(int r, int c, int maxmoves)
	{
		int random = generate.nextInt(4)+1;
		++move;
		if(mRow > 0 && mRow < r-1 && mCol > 0 && mCol < c-1)
		{
			island[mRow][mCol] = move;
			if(random == 1)
			{
				--mRow;
			}
			if(random == 2)
			{
				++mCol;
			}
			if(random == 3)
			{
				++mRow;
			}
			if(random == 4)
			{
				--mCol;
			}
		}
		if(((mRow == 0 || mRow == r-1) || (mCol == 0 || mCol == c-1)) && (island[mRow][mCol] == -1))
			{
				escaped = true;
			}
		else if(((mRow == 0 || mRow == r-1) || (mCol == 0 || mCol == c-1)) && (island[mRow][mCol] == 0))
			{
				drowned = true;
			}
		else if(move == maxmoves && mRow > 0 && mRow < r-1 && mCol > 0 && mCol < c-1)
			{
				starved = true;
			}
	}

	public void generateIsland(int r, int c, int bpercent)
	{
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
				{
					int random = generate.nextInt(100)+1;
					//on island
					if(i > 0 && j > 0 && i < r-1 && j < c-1) 
					{
						island[i][j] = 0;
					}
					//1st or last row
					else if((i == 0 || i == r-1) && (random <= bpercent))
					{
						island[i][j] = -1;
					}
					//1st or last column
					else if((j == 0 || j == c-1) && (random <= bpercent))
					{
						island[i][j] = -1;
					}
					else
					{
						island[i][j] = 0;
					}
					island[r/2][c/2] = 1;
				}
		}
	}
	
	public String printIsland(int r, int c, int bpercent)
	{
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
				{
					//on island
					if(i > 0 && j > 0 && i < r-1 && j < c-1) 
					{
						ans = ans +(EasyFormat.format(island[i][j], 3));
					}
					//1st or last row
					else if((i == 0 || i == r-1) && (island[i][j] == -1))
					{
						ans = ans +(EasyFormat.format("B", 3));
					}
					//1st or last column
					else if((j == 0 || j == c-1) && (island[i][j] == -1))
					{
						ans = ans +(EasyFormat.format("B", 3));
					}
					else
					{
						ans = ans +(EasyFormat.format("W", 3));
					}
				}
			ans = ans + "\n";
		}
		return ans;
	}
	
	public boolean escapeStatus()
	{
		if(escaped == true)
			return true;
		return false;
	}
	
	public boolean starveStatus()
	{
		if(starved == true)
			return true;
		return false;
	}
	
	public boolean drownStatus()
	{
		if(drowned == true)
			return true;
		return false;
	}
	
	public double getPEsc(int escaped, int sims)
	{
		return (0.0+escaped)/sims * 100;
	}
	
	public double getPSta(int starved, int sims)
	{
		return (0.0+starved)/sims * 100;
	}
	
	public double getPDro(int drowned, int sims)
	{
		return (0.0+drowned)/sims * 100;
	}
}