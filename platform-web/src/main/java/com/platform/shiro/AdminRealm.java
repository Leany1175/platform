package com.platform.shiro;

import com.platform.entity.Administrator;
import com.platform.service.AdminService;
import com.platform.utils.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminRealm extends AuthorizingRealm{

	@Autowired
	private AdminService adminService;

	/**
	 * 登录
	 * @param token 账户信息
	 * @return 登录账户
	 * @throws AuthenticationException 登录异常
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 用户名
		String username = (String)token.getPrincipal();
		// 密码
		String password = new String((char[]) token.getCredentials());
		// 登录查询
		Administrator admin = adminService.login(username, StringUtils.encodeMD5(password));
		if (admin == null) {
			throw new AuthenticationException("用户名或密码错误");
		}
		return new SimpleAuthenticationInfo(username, password, getName());
	}

	/**
	 * 授权
	 * @param principalCollection 主题信息
	 * @return SimpleAuthorizationInfo
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return new SimpleAuthorizationInfo();
	}
}
