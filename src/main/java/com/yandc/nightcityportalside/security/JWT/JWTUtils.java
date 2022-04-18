package com.yandc.nightcityportalside.security.JWT;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.yandc.nightcityportalside.security.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * The Class JWTUtils.
 */
@Component
public class JWTUtils {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(JWTUtils.class);
	
	/** The jwt secret. */
	@Value("${com.example.jwtSecret}")
	private String jwtSecret;
	
	/** The jwt expiration ms. */
	@Value("${com.example.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	/**
	 * Generate jwt token.
	 *
	 * @param authentication the authentication
	 * @return the string
	 */
	public String generateJwtToken(Authentication authentication) {
	
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		
	return Jwts.builder()
		.setSubject((userPrincipal.getUsername()))
		.setIssuedAt(new Date())
		.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
		.signWith(SignatureAlgorithm.HS512, jwtSecret)
		.compact();
	}
	
	/**
	 * Gets the user name from jwt token.
	 *
	 * @param token the token
	 * @return the user name from jwt token
	 */
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	/**
	 * Validate jwt token.
	 *
	 * @param authToken the auth token
	 * @return true, if successful
	 */
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
		return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}
		
		return false;
	}
}