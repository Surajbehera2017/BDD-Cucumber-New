package common;

import org.jasypt.util.text.BasicTextEncryptor;

public class PasswordEncryptor
{
	static String password="ms365dynamics";
	
	public static void main(String args[])
	{
		BasicTextEncryptor encr=new BasicTextEncryptor();
		encr.setPassword(password);
		String plainText="Madhavan17";
		String encryptedText=encr.encrypt(plainText);
		System.out.println("Encrypted password is : "+encryptedText);
		System.out.println("Decripted password is : "+decrypt(encryptedText));
	}
	
	public static String decrypt(String encryptedText)
	{
		BasicTextEncryptor encr=new BasicTextEncryptor();
		encr.setPassword(password);
		return encr.decrypt(encryptedText);
	}
}
