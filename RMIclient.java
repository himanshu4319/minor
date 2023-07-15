import java.rmi.*;
import java.rmi.registry.*;
public class RMIclient
{
	public static void main(String[] args) {
		try{
			MethodImpl md = (MethodImpl)Naming.lookup("rmi://127.0.0.1/sqrt");
			double db1 = md.getsqrt(100);
			System.out.println("SQRT "+db1);
		}
		catch(Exception e)
		{

		}
	}
}