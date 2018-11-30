package com.spotigram.utilities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTHelper {
	private static Algorithm algo = Algorithm.HMAC512("supasekrit");
	private  Logger log = Logger.getRootLogger();
	
	/*
	 * @username is assigned a JWToken if they are authenticated properly
	 * and/or assigned a new one if necessary
	 * */
	public String generateToken(String username, Boolean renew) {
		LocalDate today = LocalDate.now();
		LocalTime now = LocalTime.now();
		LocalDate expiration = LocalDate.of(
				today.getYear(), 
				today.getMonthValue(), 
				today.getDayOfMonth()
				);
		String token = JWT.create().
				withIssuer(username).
				withIssuedAt(java.sql.Date.valueOf(today)).
				withExpiresAt(java.sql.Date.valueOf(expiration)).
				sign(algo);
		if(!renew) {
			log.info("Assigning user: " + username + " with token: " + token );
		}
		
		return token;
	}
	
	/*
	 * verifying the @userToken that @username has provided to us
	 * if a @userToken is empty or an invalid token, it will return a false that will be processed 
	 * assigns a new one if it detects that the token has expired
	 * */
	public  Boolean verifyToken(String userToken) {
		
		try {
			JWTVerifier verifier = JWT.require(algo).build();
			DecodedJWT jwt = verifier.verify(userToken);
			String username = jwt.getIssuer();
			log.info("Verifying user: " + username + " with a jwt token of " + userToken);
			log.info("User " + username + " was verified successfully");
			return false;
		}catch (JWTDecodeException exception){
			System.out.println("Someone using token: "+ userToken + " tried to do authenticate with an invalid token");
		}catch(InvalidClaimException exception2) {
			System.out.println("Someone using token: "+ userToken + " tried to do authenticate with an invalid token");
		}
		return true;
	}
	
	public String renewToken(String username) {
		
		return this.generateToken(username, true);
	}
	
	
}
