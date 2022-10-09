package fr.ensicaen.webservices.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;

@Component
public class JWTUtils {
    private final String token = System.getenv().get("JWTTOKEN");

    public Claims verify(String authorization) throws Exception {
        try {
            return Jwts.parserBuilder().setSigningKey(token.getBytes(StandardCharsets.UTF_8)).build().parseClaimsJws(authorization).getBody();
        } catch (Exception e) {
            throw new AccessDeniedException("Invalid token");
        }
    }
}
