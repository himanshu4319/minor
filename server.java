import java.net.*;
import java.io.*;
class server
{
	Double area;
	public server() 
	{
		try{
			//creating server socket
			ServerSocket ss = new ServerSocket(4000);
			System.out.println("Server Started");
			while(true)
			{
				//creating socket for server socket
				Socket sock = ss.accept();

				//displaying port number 
				System.out.println("\n\n Local port number of sevrer is ->>>>"+sock.getLocalPort());

				//creating inputstream to get data from client
				DataInputStream din = new DataInputStream(sock.getInputStream());

				//creatting output stream to send data to client
				DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

				area =din.readDouble();
				dout.writeDouble(area);

				din.close();
				dout.close();
				sock.close();

			}
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new server();
	}
}