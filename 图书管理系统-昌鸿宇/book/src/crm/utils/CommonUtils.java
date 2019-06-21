package crm.utils;

import java.util.UUID;

public class CommonUtils 
{
	public static String getUUID()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
