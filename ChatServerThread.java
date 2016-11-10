import java.util.concurrent.ConcurrentHashMap;

class ChatServerThread extends Thread
{
	ConcurrentHashMap<String, ChatUser> allUsers;
	ChatUser currentUser;
		
	ChatServerThread()
	{
			
	}
		
	ChatServerThread(ConcurrentHashMap<String, ChatUser> allUsers, ChatUser currentUser)
	{
		this.allUsers = allUsers;
		this.currentUser = currentUser;
	}
}