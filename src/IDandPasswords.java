import java.util.HashMap;

public class IDandPasswords {
	
	private HashMap<String,String> loginInfo = new HashMap<String,String>();
	
	public IDandPasswords(){
		
		loginInfo.put("Bro", "Password");
		loginInfo.put("Brometheus", "12345");
		loginInfo.put("BroCode", "abc123");
		
		
		
	}

	
	protected HashMap<String,String> getLoginInfo()
	{
		
		return loginInfo ;
	}
}
