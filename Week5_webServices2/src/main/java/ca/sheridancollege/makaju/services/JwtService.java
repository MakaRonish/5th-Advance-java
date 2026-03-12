package ca.sheridancollege.makaju.services;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private static final String SECTET_KEY="SU4gaGVyZSB3ZSBjcmVhdGUgc29tZSBzZWNyZXQga2V5IC0gaXQgc2hvdWQgYmUgb3JpZ2luYWwgYW5kIGEgZGVjZW50IGxlbmd0aA==";
	
//	public static void main(String[] args) {
//		String genSecretKey= Encoders.BASE64.encode("IN here we create some secret key - it shoud be original and a decent length"
//									 .getBytes());
//		System.out.println(genSecretKey);
//		
//	}
	
	private SecretKey getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECTET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
		
	}
	
	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		return Jwts.builder()
				.claims(extraClaims)
				.subject(userDetails.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date (System.currentTimeMillis()+1000*60*60))
				.signWith(getSignInKey()).compact();
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser()
				.verifyWith(getSignInKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
	}
	
	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}

	
	public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
		}
	
	private Date extractExperation(String token) {
		return extractClaim(token, Claims::getExpiration);
		
	}
	private boolean isTokenExpired(String token) {
		return extractExperation(token).before(new Date());
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username= extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
