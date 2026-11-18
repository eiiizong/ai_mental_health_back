package com.example.aispringboot.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.aispringboot.config.JwtConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Date;

public class JwtTokenUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static JwtConfig getJwtConfig() {
        return applicationContext.getBean(JwtConfig.class);
    }

    /**
     * 生成token的方法
     *
     * @param userId
     * @param username
     * @param roleType
     * @return
     */
    public static String generateToke(String userId, String username, String roleType) {
        try {
            // 获取jwt配置
            JwtConfig jwtConfig = getJwtConfig();
            // 生成签名的算法
            Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret());
            // 生成过期的时间
            Date expiration = new Date(System.currentTimeMillis() + jwtConfig.getExpiration());

            return JWT.create()
                    .withClaim("userId", userId)
                    .withClaim("username", username)
                    .withClaim("roleType", roleType)
                    .withExpiresAt(expiration) // 设置过期时间
                    .withIssuedAt(new Date()) // 设置签发时间
                    .withIssuer("EIIIZONG") // 实则签发者
                    .sign(algorithm);// 实则签发者
        } catch (Exception e) {
            throw new RuntimeException("生成token失败：" + e);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        JwtTokenUtil.applicationContext = applicationContext;
    }
}
