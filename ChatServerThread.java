import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

class ChatServerThread extends Thread
{
	ConcurrentHashMap<String, ChatUser> allUsers;
	ChatUser currentUser;
	boolean isUserConnected;
		
	ChatServerThread(ConcurrentHashMap<String, ChatUser> allUsers, ChatUser currentUser)
	{
		this.allUsers = allUsers;
		this.currentUser = currentUser;
	}
	
	public void run()
	{
		//this allows for one client to connect to multiple conversations
		//the first chunk of this while loop will have code to connect 2 users
		//the middle chunk will have code to exchange messages 
		//the last chunk will have code to tear down connection (if needed)
		while(isUserConnected)
		{
			try {
				if(currentUser.isListener())
				{
					//check the users connection variable? if another user connected to them then it should be set...
					//maybe you don't need to do anything other than figure out if the user disconnects...
				}
				else
				{
					//ask for and take in the username of the target user from connectionSocket
					currentUser.outputStream.writeBytes("You may begin a chat with a user by typing their username or type \'Listener\' if you want a user to initiate a chat with you");
					String targetUsername = currentUser.inputStream.readLine();
					if(targetUsername.equals("Listener") || targetUsername.equals("listener"))
					{
						currentUser.setListener(true);
						//TODO wait for someone to start a chat with you
					}
					else
					{
						ChatUser targetUser = allUsers.get(targetUsername);
						if(currentUser.setChatPartner(targetUser)) //connection with target is made
						{
							currentUser.outputStream.writeBytes("Connected.");
							boolean myTurnToTalk;
							while(currentUser.getChatPartner() == targetUser && targetUser.getChatPartner() == currentUser) // client and target are both active and connected to each other 
							{
								//TODO THIS IS ONE LIFECYCLE OF SENDING A SINGLE MESSAGE (alternates who sends each loop)
							}
						}
						else //connection with target is not made
						{
							currentUser.outputStream.writeBytes("Connection cannot be made.");
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//TEAR DOWN CONNECTION WITH CLIENT:
		//TODO tear down input and output streams (this user)
		//TODO close connectionSocket
		//TODO remove user from hashmap of all users
	}
}