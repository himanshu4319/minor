import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;
public class rmi_test_client
{
	public static void main(String[] args) {
		try{
			method md = (method)Naming.lookup("rmi://127.0.0.1/cube1");
			System.out.println("Enter a number whose cube you want to calculate : ");
			Scanner sc = new Scanner(System.in);
			int digit = sc.nextInt();

			System.out.println("cube of "+digit+" is : "+md.getcube(digit));
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}