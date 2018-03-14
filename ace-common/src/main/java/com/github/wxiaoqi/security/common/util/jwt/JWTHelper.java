package com.github.wxiaoqi.security.common.util.jwt;


import com.github.wxiaoqi.security.api.vo.jwt.IJWTInfo;
import com.github.wxiaoqi.security.api.vo.jwt.JWTInfo;
import com.github.wxiaoqi.security.common.constant.JwtConstants;
import com.github.wxiaoqi.security.common.util.KeyHelper;
import com.github.wxiaoqi.security.common.util.StringHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * Created by ace on 2017/9/10.
 */
public class JWTHelper {
    /**
     * 密钥加密token
     *
     * @param jwtInfo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo, String priKeyPath, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(jwtInfo.getUniqueName())
                .claim(JwtConstants.JWT_KEY_USER_ID, jwtInfo.getId())
                .claim(JwtConstants.JWT_KEY_NAME, jwtInfo.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, KeyHelper.getPrivateKey(priKeyPath))
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(JwtConstants.JWT_KEY_USER_ID)),
                StringHelper.getObjectValue(body.get(JwtConstants.JWT_KEY_NAME)));
    }

}
