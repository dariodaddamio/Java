import java.util.ArrayList;
import java.util.Collections;

public class InsuranceTest 
{
	public static void main(String[] args)
	{
		EasyReader premData = new EasyReader("PremTable.dat");
		EasyReader custData = new EasyReader("customer.dat");
		ArrayList<Customer> custAL = new ArrayList<Customer>();
		ArrayList<Premium> premAL = new ArrayList<Premium>();
		
		//making custAL
		String c = custData.readLine();
		while(c != null)
		{
			String[] carray = c.split("\\*");
			String name = carray[0];
			int age = Integer.valueOf(carray[1]);
			Customer customer = new Customer(name, age);
			custAL.add(customer);
			c = custData.readLine();
		}
		//unsorted
		System.out.println("Unsorted Data:");
		System.out.println(EasyFormat.format("Name",0) + EasyFormat.format("Age", 25));
		for(int i = 0; i < custAL.size(); i++)
		{
		System.out.println(EasyFormat.format(custAL.get(i).getName(), 23, 'L', 0) + EasyFormat.format(custAL.get(i).getAge(), 5));
		}
		//sorted
		Collections.sort(custAL);
		System.out.println();
		System.out.println("Sorted Data:");
		System.out.println(EasyFormat.format("Name",0) + EasyFormat.format("Age", 25));
		for(int i = 0; i < custAL.size(); i++)
		{
			System.out.println(EasyFormat.format(custAL.get(i).getName(), 23, 'L', 0) + EasyFormat.format(custAL.get(i).getAge(), 5));
		}
		
		//making premAL
		int age = premData.readInt();
		while(age != 0)
		{
		int price = premData.readInt();
		Premium premium = new Premium(age, price);
		premAL.add(premium);
		age = premData.readInt();
		}
		//premium
		System.out.println();
		System.out.println("Premium Table:");
		System.out.println(EasyFormat.format("Name",0) + EasyFormat.format("Age", 25) + EasyFormat.format("Premium", 10));
		//Collections.sort(premAL); unnecessary because list is already sorted
		
		for(int i = 0; i < custAL.size(); i++)
		{
			Premium currentObj = new Premium(custAL.get(i).getAge(), 0);
			int location = Collections.binarySearch(premAL, currentObj);
			if(location < 0)
			{
				location = location*(-1) -1;
			}
			System.out.println(EasyFormat.format(custAL.get(i).getName(), 23, 'L', 0) + EasyFormat.format(custAL.get(i).getAge(), 5) + EasyFormat.format(premAL.get(location).getPrice(),8));
		}
	}
}
