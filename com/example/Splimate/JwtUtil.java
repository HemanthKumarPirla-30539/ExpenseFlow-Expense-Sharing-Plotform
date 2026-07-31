package com.example.Splimate;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET =
            "splitmatejwtsecretkey2026hemanthkumarprojectspringboot";

    public String generateToken(String username) {
    	return Jwts.builder().setSubject(username)
    			   .setIssuedAt(new Date())
    			   .setExpiration(new Date(
    					   System.currentTimeMillis()+1000*60*60))
    			   .signWith(SignatureAlgorithm.HS256,SECRET) //this strike means this is depricated so jwt has new synatx 
    					   .compact();
    }
    public String extractUsername(String token) {

        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {

        try {

            Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}