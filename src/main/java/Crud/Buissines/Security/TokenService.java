package Crud.Buissines.Security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora


    public String gerartoken(String usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API demo")
                    .withSubject(usuario)
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }


    public String getSubject(String tokenJwt) {
        if (tokenJwt == null || tokenJwt.isBlank()) {
            return null;
        }
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API demo")
                    .build()
                    .verify(tokenJwt)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            // Em vez de travar, retornamos null para o filtro decidir o que fazer
            return null;
        }
    }


    private Instant dataExpiracao() {

        return LocalDateTime.now().plusHours(10).toInstant(ZoneOffset.systemDefault().getRules().getOffset(Instant.now()));
    }
}