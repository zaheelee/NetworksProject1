import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

class ChatUser
{
	private String username;
	private Socket connectionSocket;
	public BufferedReader inputStream;
	public DataOutputStream outputStream;
	private ChatUser chatPartner;
	private boolean isListener;
	
	
	public ChatUser()
	{
		username = null;
		chatPartner = null;
	}
	
	public ChatUser(String username, Socket connectionSocket, BufferedReader inputStream, DataOutputStream outputStream)
	{
		this.username = username;
		this.connectionSocket = connectionSocket;
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		chatPartner = null;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public Socket getConnectionSocket()
	{
		return connectionSocket;
	}
	
	public void setConnectionSocket(Socket connection)
	{
		connectionSocket = connection;
	}
	
	public boolean isListener() {
		return isListener;
	}

	public void setListener(boolean isListener) {
		this.isListener = isListener;
	}
	
	public ChatUser getChatPartner()
	{
		return chatPartner;
	}
	
	/**
	 * Sets the chat partner of the current user if the target partner is either chatting with no one, 
	 * or chatting with the current user
	 * @param partner
	 * @return true if the value of the chatPartner is set to be the input partner. 
	 * False if the partner was null or chatting with someone else
	 */
	public boolean setChatPartner(ChatUser partner)
	{
		if(partner != null && (partner.getChatPartner() == null || partner.getChatPartner() == this))
		{
			partner.setChatPartner(this);
			this.setChatPartner(partner);
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	public void removeChatPartner()
	{
		this.chatPartner = null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatUser other = (ChatUser) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}