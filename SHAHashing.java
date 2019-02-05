package hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class SHAHashing
{
    public static void main(String[] args)throws Exception
    {
//        System.out.println("GEnrated============="+generateSecrete());
    	String password = "123456abc";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb.toString());

        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	System.out.println("Hex format : " + hexString.toString());
    	
        System.out.println("==================="+encrypSHA1("12354"));
    }
    public static String encrypSHA1(String Pass) throws NoSuchAlgorithmException{
    	
    	
    	String password = Pass;

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 32).substring(1));
        }

//        System.out.println("Hex format : " + sb.toString());

        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
//    	System.out.println("Hex format : " + hexString.toString());
    	
    	return hexString.toString();
    }
    
    private static final char[] alphaString = "abcdefghijklmnopqrstuvwxyz0123456789asdfghjkkjhgfdsdfghj123456787654321"
            .toCharArray();

    public static String generateSecrete() {
        int length=8;
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(alphaString.length);
            result[i] = alphaString[randomCharIndex];
        }
        return new String(result);
    }
    
    public static String generateSecrete1() {
        int length=33;
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(alphaString.length);
            result[i] = alphaString[randomCharIndex];
        }
        return new String(result);
    }
}