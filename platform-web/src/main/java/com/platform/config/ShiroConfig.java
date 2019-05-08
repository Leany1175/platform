package com.platform.config;

import com.platform.shiro.AdminRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ShiroConfig {

	/**
	 * 安全管理器
	 * @param adminRealm 管理员域
	 * @param cacheManager 缓存管理器
	 * @return 安全管理器
	 */
	@Bean(name = "securityManager")
	public WebSecurityManager securityManager(AdminRealm adminRealm, CacheManager cacheManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(adminRealm);
		securityManager.setCacheManager(cacheManager);
//		ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
//		// 字符串转换为权限对象
//		authorizer.setPermissionResolver(new WildcardPermissionResolver());
//		// authorizer.setRolePermissionResolver();
//		securityManager.setAuthorizer(authorizer);

		return securityManager;
	}

	/**
	 * 缓存管理器 使用EHcache实现
	 * @return 缓存管理器
	 */
	@Bean(name = "cacheManager")
	public EhCacheManager ehCacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return cacheManager;
	}

	/**
	 * 凭证匹配器
	 * @return 凭证匹配器
	 */
	@Bean(name = "credentialsMatcher")
	public HashedCredentialsMatcher credentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		// 散列算法:这里使用MD5算法
		credentialsMatcher.setHashAlgorithmName("md5");
		// 散列的次数，比如散列两次，相当于 md5(md5(""))
		credentialsMatcher.setHashIterations(1);
		return credentialsMatcher;
	}

	/**
	 * Realm 实现
	 * @param credentialsMatcher 匹配凭证
	 * @return 域
	 */
	@Bean(name = "adminRealm")
	public AdminRealm myRealm(HashedCredentialsMatcher credentialsMatcher) {
		return new AdminRealm();
	}

	/**
	 * Shiro 生命周期处理器
	 * @return 生命周期处理器
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}


	/**
	 * 会话管理器
	 * @return 会话管理器
	 */
	@Bean(name = "webSessionManager")
	public DefaultWebSessionManager webSessionManager() {
		DefaultWebSessionManager webSessionManager = new DefaultWebSessionManager();
		webSessionManager.setGlobalSessionTimeout(1800000);
		webSessionManager.setDeleteInvalidSessions(true);
		webSessionManager.setSessionValidationSchedulerEnabled(true);
		webSessionManager.setSessionIdCookieEnabled(true);
		return webSessionManager;
	}

	/**
	 * shiroFilterFactoryBean
	 * @param securityManager 安全管理器
	 * @return bean
	 */
	@Bean(name = "shiroFilterFactoryBean")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(WebSecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(securityManager);

		// 登录页面
		factoryBean.setLoginUrl("/administrator/loginPage");
		// 未授权
//		factoryBean.setUnauthorizedUrl("/403/page");

		Map<String, String> filterChainDefinitionMap = factoryBean.getFilterChainDefinitionMap();

		filterChainDefinitionMap.put("/**/*.js", "anon");
		filterChainDefinitionMap.put("/**/*.css", "anon");
		filterChainDefinitionMap.put("/**/*.jpg", "anon");
		filterChainDefinitionMap.put("/**/*.png", "anon");

		filterChainDefinitionMap.put("/admin/**", "authc");
		factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return factoryBean;
	}

}
