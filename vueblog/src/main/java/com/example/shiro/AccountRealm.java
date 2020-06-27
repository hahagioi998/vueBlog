package com.example.shiro;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.JwtUtils;
import io.jsonwebtoken.Jwt;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;
    /**
     * 判断token是不是jwtToken
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    //得到用户之后获取权限，封装之后返回给shiro
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principles) {
        return null;
    }

    //身份验证，比如校验密码
    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;

        //返回用户的ID,并强转为long
        String userId =  jwtUtils.getClaimByToken((String)jwtToken.getPrincipal()).getSubject();
        User user = userService.getById(Long.valueOf(userId));

        if(user == null){
            throw new UnknownAccountException("账号不存在");
        }
        if(user.getStatus() == -1){
            throw new LockedAccountException("账号不存在");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtils.copyProperties(user, profile);
        System.out.println("");
        return new SimpleAuthenticationInfo((PrincipalCollection) profile, jwtToken.getCredentials());
    }
}
