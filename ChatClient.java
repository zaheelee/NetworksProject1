import java.io.*;
import java.net.*;

class ChatClient 
{
	public static void main(String argv[]) throws Exception
	{
		//Put any necessary variables here
		boolean connectedToServer = true;
		String hostname = "";
		int portNum = 0;
		String typedMessage = "";
		String recievedMessage = "";
		
		//create input stream from the keyboard
		BufferedReader inFromKeyboard = new BufferedReader(new InputStreamReader(System.in));
		
		//ask for and save host name
		System.out.println("What is the Hostname of the Server?");
		hostname = inFromKeyboard.readLine();
		
		//prompt for and save the port number of the server 
		System.out.println("What is the port number?");
		portNum = Integer.parseInt(inFromKeyboard.readLine());
		
		//create client socket and connect to server and port
		Socket clientSocket = new Socket(hostname, portNum);
		
		//create output stream attached to socket 
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		//create input stream attached to socket
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		while(connectedToServer) //TODO while connection with server thread is still valid
		{
			System.out.println(inFromServer.readLine()); //instructions for the user to read
			typedMessage = inFromKeyboard.readLine(); //user input
			//TODO see if data is a quit command, set connectedToServer accordingly
			
			outToServer.writeBytes(typedMessage); //send user input to server
			recievedMessage = inFromServer.readLine();
			
			System.out.println(recievedMessage);
			
			if(recievedMessage.equals("Connected."))
			{
				
				boolean myTurnToTalk = false;//set this based on response from server
				
				while(true) //TODO while connection with another user is valid
				{
					if(myTurnToTalk) //TODO it's your turn to talk
					{
						//TODO save data from keyboard input
						
						//TODO send data to server
					}
					else//TODO it is not your turn to talk
					{
						//TODO save data from server
						
						//TODO display data from server
					}
					myTurnToTalk = !myTurnToTalk;
				}
			}
		}
		clientSocket.close();
	}
}