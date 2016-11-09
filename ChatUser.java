

class ChatUser
{

	//TODO determine if this needs to contain Client Socket information
	
	private String username;
	
	private ChatUser chatPartner;
	
	public ChatUser()
	{
		username = null;
		chatPartner = null;
	}
	
	public ChatUser(String username)
	{
		this.username = username;
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
}