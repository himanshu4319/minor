import java.net.*;
import java.io.*;
import java.util.Scanner;
class client
{
	Double text, result;
	client()
	{
		try{
			Socket client_sock = new Socket("127.0.0.1",4000);


			Scanner input = new Scanner(System.in);
			System.out.println("Enter a String :");
			text=input.nextDouble();

			//creating datainput stream to get data from server
			DataInputStream dis = new DataInputStream(client_sock.getInputStream());


			//creating dataoutputStream to send data to server
			DataOutputStream dos = new DataOutputStream(client_sock.getOutputStream());

			dos.writeDouble(text);
			dos.flush();

			//getting result from server
			result = dis.readDouble();

			System.out.println(result);

			dis.close();
			dos.close();
			client_sock.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
	public static void main(String[] args) {
		new client();
	}
}