package edu.kh.teamPJ.common;
import java.security.MessageDigest;
import java.util.Random;

public class SHA256 {
	
	public static String getSHA256(String input) {
		
		StringBuffer result = new StringBuffer();
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			// 가염 처리 과정
			byte[] salt = "Hello Salt".getBytes();
			digest.reset();
			digest.update(salt);
			byte[] chars = digest.digest(input.getBytes("UTF-8"));
			
			for(int i = 0; i < 6 ; i++) {
				String hex = Integer.toHexString(0xff & chars[i]);
				if(hex.length() == 1) result.append("0");
				result.append(hex);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
}
