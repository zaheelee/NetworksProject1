import java.io.*;
import java.net.*;

class ChatServer 
{
	public static void main(String argv[]) throws Exception
	{
		//Put any shared variables you may need up here 
		
		//create the welcome socket
		//this is what new clients connect to before making the connectionSocket
		ServerSocket welcomeSocket = new ServerSocket(5001);
		
		/*TODO: design implementation with threads! Make sure to 
		allow multiple connectionSockets to exist at once!*/
		
		//each loop represents one lifecycle of a client connection
		while(true) //because you want the server always running
		{
			//TODO create connectionSocket from an accepted welcomeSocket
			
			//TODO create input stream from connectionSocket
			
			//TODO create output stream to connectionSocket (this user)
			
			//TODO take in the username from that connectionSocket
			
			//TODO check if that username is already in use
				//TODO if in use, deny connection, if not vice versa
			
			//this allows for one client to connect to multiple conversations
			//the first chunk of this while loop will have code to connect 2 users
			//the middle chunk will have code to exchange messages 
			//the last chunk will have code to tear down connection (if needed)
			while(true /* the client has not tried to disconnect */)
			{
				//TODO take in the username of the target from connectionSocket
			
				//TODO check if target is active and free, active and busy, or inactive
					//TODO if target is active and busy, tell client
					//TODO if target is inactive, tell client
					//TODO if target is active and free:
				while(true /* client and target are both active and connected to each other */) //TODO 
				{
					//THIS IS ONE LIFECYCLE OF SENDING A SINGLE MESSAGE (alternates who sends each loop)
				}
			}
			
			//TEAR DOWN CONNECTION WITH CLIENT:
			//TODO tear down input and output streams (this user)
			//TODO close connectionSocket
		}
		//END OF LOOP, WAIT FOR ANOTHER CLIENT CONNECTION
		
	}
}