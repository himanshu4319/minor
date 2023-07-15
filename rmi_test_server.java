import java.rmi.registry.*;
import java.rmi.server.*;
import java.rmi.*;

interface method extends Remote
{
	int getcube(int number) throws RemoteException;
}

public class rmi_test_server extends UnicastRemoteObject implements method{
	
	//constructor
	public rmi_test_server() throws RemoteException
	{
		System.out.println("Server is running");
	}
	public int getcube(int number)
	{
		number = number*number*number;
		return number;
	}
	public static void main(String[] args) {
		try{
			rmi_test_server test = new rmi_test_server();
			Naming.rebind("cube1",test);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}