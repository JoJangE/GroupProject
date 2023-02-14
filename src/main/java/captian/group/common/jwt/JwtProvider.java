package captian.group.common.jwt;

import captian.group.User.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    public String issueAccessToken(User user) {
        long time = 1800000;
        return issueToken(user, time);
    }

    public String issueRefreshToken(User user) {
        long time = 604800000; // 7일
        return issueToken(user, time);
    }

    private String issueToken(User user, long time) {
        Date expiration = new Date(System.currentTimeMillis() + time);

        String token = Jwts.builder()
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret")
                .compact();

        return token;
    }
}
