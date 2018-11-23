package com.sunp.shiro;

import com.sunp.model.User;
import com.sunp.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IntelliJ IDEA.
 * User: sunpeng
 * Date: 2017/9/8
 * Time: 22:21
 * Describe:
 */
public class OtherRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证用户的操作
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //从假数据源中拿当前用户数据
        User userDao = userService.getUserInfo(token.getUsername());
        if (userDao==null){
            //扔出个异常，currentUser.login(token);可以 catch 到
            throw new UnknownAccountException("未知用户");
        }

        //如果数据库中存在这个用户名
        if(userDao.getUserName().equals(token.getUsername())){


            //创建认证对象，传入数据库存在的对象账号和密码，内部会根据 currentUser.login(token) 的 token 进行比较
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
                    userDao.getUserName(),
                    userDao.getUserPassword(),
                    this.getName());

            return authcInfo;
        }
        return null;
    }

}