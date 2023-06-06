
public class Customer implements Comparable<Customer>
{
	private String name;
	private int age;
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public int compareTo(Customer otherCustomer)
	{
		int ans = 0;
		String other = otherCustomer.getName();
		if(name.compareTo(other)==0)
			return 0;
		if(name.compareTo(other)>0) 
			return 1;
		else if(name.compareTo(other)<0)
			return -1;
		
		return ans;
	}
}
