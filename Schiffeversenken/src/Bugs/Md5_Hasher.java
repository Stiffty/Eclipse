package Bugs;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5_Hasher {

	public Md5_Hasher() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i < 101; i++) {
			try {
				System.out.println(md5Hash("Index.php"+String.valueOf(i))+".php");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	 public static String md5Hash (String input) throws NoSuchAlgorithmException {
	        String result = input;
	        if(input != null) {
	            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	            messageDigest.update(input.getBytes());
	            BigInteger hash = new BigInteger(1, messageDigest.digest());
	            result = hash.toString(16);
	            while (result.length() < 32) {
	                result = "0"+result;
	            }
	        }
	        return result;
	}
}
