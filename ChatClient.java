import java.io.*;
import java.net.*;

class ChatClient 
{
	public static void main(String argv[]) throws Exception
	{
		//Put any necessary variables here
		boolean connectedToServer = false;
		String hostname = "";
		int portNum = 0;
		
		//create input stream from the keyboard
		BufferedReader inFromKeyboard = new BufferedReader(new InputStreamReader(System.in));
		
		//TODO prompt for the host name of server 
		
		//TODO save host name
		
		//TODO prompt for the port number of the server 
		
		//TODO save port number
		
		//TODO create client socket and connect to server and port 5001
		
		//TODO create output stream attached to socket 
		
		//TODO create input stream attached to socket
		
		while(connectedToServer) //TODO while connection with server is still valid
		{
			//TODO save data taken from keyboard input
			
			//TODO see if data is a quit command, set connectedToServer accordingly
			
			//TODO send data to server
			
			//TODO receive data from server
			
			//TODO process data taken from server
				//TODO if a connection with another user is successful, 
					//data will also contain whether you speak first
			
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
		//TODO close client socket
	}
}