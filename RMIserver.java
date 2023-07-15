import java.rmi.server.*;
import java.rmi.registry.*;
import java.rmi.*;
interface MethodImpl extends Remote
{
	double getsqrt(double dbt)throws RemoteException;
}
public class RMIserver extends UnicastRemoteObject implements MethodImpl
{
	public RMIserver() throws RemoteException
	{
		System.out.println("the Server is instantiated");
	}
	public double getsqrt(double dbt)
	{
		return(Math.sqrt(dbt));
	}
	public static void main(String[] args) {
		try{
			RMIserver server = new RMIserver();
			Naming.rebind("sqrt",server);
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}
	}
}