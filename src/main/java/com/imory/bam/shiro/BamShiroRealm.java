package com.imory.bam.shiro;

import com.imory.bam.sysuser.bean.SysUser;
import com.imory.bam.sysuser.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/18
 */
public class BamShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        System.out.println("BamShiroRealm.doGetAuthenticationInfo");

        //登录账户
        String logonId = (String) authenticationToken.getPrincipal();

        SysUser sysUser = sysUserService.findSysUserByLogonId(logonId);
        if (sysUser == null)
        {
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                sysUser,
                sysUser.getPassword(),
                getName()
        );
        return simpleAuthenticationInfo;
    }
}
