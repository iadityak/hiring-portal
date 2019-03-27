package com.idemia.hiring.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import com.idemia.hiring.constants.AppConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/***
 * 
 * 
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         This class deals with the creation and decoding of of JWT(JSON Web
 *         Token) for user authentication purpose.
 */
@Component
public class JsonWebTokenUtility {

	public String createJwtToken(String email, String issuer, String subject, String id) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(AppConstants.jwtSecretKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setIssuedAt(now).setIssuer(issuer).setSubject(subject).setId(id)
				.signWith(signatureAlgorithm, signingKey);

		return builder.compact();
	}

	public Claims decodeJwtToken(String jwtToken) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(AppConstants.jwtSecretKey))
				.parseClaimsJws(jwtToken).getBody();
		return claims;
	}

}
