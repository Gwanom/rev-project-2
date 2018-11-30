package com.spotigram.utilities;

import java.math.BigInteger;
import java.security.*;

public class PasswordHelper {
	public static PasswordHelper Hasher = new PasswordHelper();
	public Boolean passHasher(String password, String compareToPassword) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			byte[] digestedMessage = md.digest(password.getBytes());
			BigInteger bi = new BigInteger(1, digestedMessage);
			String hashedPassword = bi.toString(16);
			if(hashedPassword.equals(compareToPassword)) {
				return true;
			}else {
				return false;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public String newUser(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			byte[] digestedMessage = md.digest(password.getBytes());
			BigInteger bi = new BigInteger(1, digestedMessage);
			String hashedPassword = bi.toString(16);
			return hashedPassword;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
