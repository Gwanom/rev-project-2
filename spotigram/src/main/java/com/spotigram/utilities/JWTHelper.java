package com.spotigram.utilities;

import java.time.LocalDate;

import org.apache.log4j.Logger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTHelper {
	private static Algorithm algo = Algorithm.HMAC512("supasekrit");
	private static Logger log = Logger.getRootLogger();
	public static  String generateToken(String username) {
		LocalDate today = LocalDate.now();
		LocalDate expiration = LocalDate.of(
				today.getYear(), 
				today.getMonthValue(), 
				today.getDayOfMonth()+1
				);
		String token = JWT.create().
				withIssuer(username).
				withIssuedAt(java.sql.Date.valueOf(today)).
				withExpiresAt(java.sql.Date.valueOf(expiration)).
				sign(algo);
		log.info("Assigning user: " + username + " with token: " + token );
		return token;
	}
	public static Boolean verifyToken(String username, String userToken) {
		log.info("Verifying user: " + username + " with a jwt token of " + userToken);
		try {
			JWTVerifier verifier = JWT.require(algo).withIssuer(username).build();
			DecodedJWT jwt = verifier.verify(userToken);
			log.info("User " + username + " was verified successfully");
			return true;
		}catch (JWTDecodeException exception){
			System.out.println("User: "+ username + " tried to do something with an invalid token");
		}
		return false;
	}
}
