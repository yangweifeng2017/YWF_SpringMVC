package com.ywf.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义的指定Shiro验证用户登录的类
 * 
 * @author yangweifeng
 *
 */
public class UserRealm extends AuthorizingRealm {

//	private static final Logger logger = Logger.getLogger(UserController.class);

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// String username = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// User user = userService.findByUsername(username);
		// List<Role> list = userRoleService.getAllrole(user.getId());
		// Set<String> setRoles = getRoles(list);
		// authorizationInfo.setRoles(setRoles);
		// authorizationInfo.setStringPermissions(userService.findPermissions(username));
		return authorizationInfo;
	}
	/**
	 * 将角色转化为字符串，并去重
	 * 
	 * @param list
	 * @return
	 */
	// public static Set<String> getRoles(List<Role> list){
	// Set<String> setRoles = new HashSet<String>() ;
	// for (Role role : list) {
	// setRoles.add(role.getName());
	// }
	// return setRoles;
	// }

	/**
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		/*
		try {
			String username = (String) token.getPrincipal();
			User user = userService.findByUsername(username);
			if (user == null) {
				//logger.error("没有找到 " + username + " 用户");
				CommonUntil.logPrint("error",UserRealm.class.getCanonicalName() + "|没有找到|" + username);
			}
			// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
			authenticationInfo = new SimpleAuthenticationInfo(user.getUser_name(), user.getUser_pass(), getName());
		} catch (Exception e) {
			//logger.error("doGetAuthenticationInfo" + e.getMessage());
			CommonUntil.logPrint("error",UserRealm.class.getCanonicalName() + "|error|" + e.getMessage());
		}*/
		return (AuthenticationInfo) authorizationInfo;
	}
}