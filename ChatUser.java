import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

class ChatUser
{
	private String username;
	private Socket connectionSocket;
	BufferedReader inputStream;
	DataOutputStream outputStream;
	private ChatUser chatPartner;
	
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
	
	public ChatUser getChatPartner()
	{
		return chatPartner;
	}
	
	public boolean setChatPartner(ChatUser partner)
	{
		if(partner.getChatPartner() == null || partner.getChatPartner() == this)
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