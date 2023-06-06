
public class Premium implements Comparable<Premium>
{
	private int age;
	private int price;
	
	public Premium(int age, int price)
	{
		this.age = age;
		this.price = price;
	}
	public int getAge()
	{
		return age;
	}
	public int getPrice()
	{
		return price;
	}
	public int compareTo(Premium otherAge)
	{
		int ans = 0;
		if(age  == otherAge.getAge())
			return 0;
		if(age > otherAge.getAge()) 
			return 1;
		else if(age < otherAge.getAge())
			return -1;
		
		return ans;
	}
}
