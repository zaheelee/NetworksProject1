import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class ChatServer 
{
	public static void main(String argv[]) throws Exception
	{
		//Put any shared variables you may need up here 
		ConcurrentHashMap<String, ChatUser> allUsers = new ConcurrentHashMap<String, ChatUser>();
		
		ArrayList<ChatServerThread> allThreads = new ArrayList<ChatServerThread>();
		
		//create the welcome socket
		//this is what new clients connect to before making the connectionSocket
		ServerSocket welcomeSocket = new ServerSocket(5001);
		
		
		//each loop represents one lifecycle of a client connection
		while(true) //because you want the server always running
		{
			// create connectionSocket from an accepted welcomeSocket
			Socket connectionSocket = welcomeSocket.accept();
			
			//create input stream from connectionSocket
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			//create output stream to connectionSocket (this user)
			DataOutputStream outputStream = new DataOutputStream(connectionSocket.getOutputStream());
			
			String username = null;
			while(username == null)
			{
				username = retrieveUsername(inputStream, outputStream, allUsers);
			}
			ChatUser user = new ChatUser(username, connectionSocket, inputStream, outputStream);
			allUsers.put(user.getUsername(), user);
			
			ChatServerThread t = new ChatServerThread(allUsers, user);
			allThreads.add(t);
			t.start();
		}
		//END OF LOOP, WAIT FOR ANOTHER CLIENT CONNECTION
		
	}
	
	public static String retrieveUsername(BufferedReader inputStream, DataOutputStream outputStream, ConcurrentHashMap<String, ChatUser> allUsers) throws IOException
	{
		outputStream.writeBytes("What is your username?");
		String username = inputStream.readLine();
		
		if(allUsers.containsKey(username))
		{
			outputStream.writeBytes("This username is already in use, please try another one");
			return null;
		}
		else
		{
			return username;
		}
	}
}