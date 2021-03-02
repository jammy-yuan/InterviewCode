package com.gec.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gec.domain.User;
import com.gec.realms.CustomerRealm;
import com.gec.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerRealm customerRealm;
	
	@RequestMapping("/clearCache")
	@ResponseBody
	public String clearCache() {
		customerRealm.clearCached();
		return "clearCached OK..";
	}

	// ?errcode=1" 地址栏传参
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "forward:/login.jsp";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(User user) {
		printMark("login");
		// (1) 拿到用户身份信息, 凭证信息。
		String username = user.getUsername(); // 身份信息
		String password = user.getPassword(); // 凭证信息(没加密的)

		// (2) 要对凭证进行 MD5 加密处理。
		String md5Pass = encodeMD5(password); // MD5 加密的

		// (3) 把这些 "身份, 凭证信息" 注入一个令牌: Token。
		UsernamePasswordToken token = new UsernamePasswordToken(username, md5Pass);

		// (4) 得到 主体 Subject。
		Subject subject = SecurityUtils.getSubject();

		// (5) 执行登录, 传入令牌。
		// 没有问题, 直接去 User 主页
		String resPath = "redirect:/User/index";
		try {
			// {ps} 登陆时, 自动调用 自定义 Realm 的认证方法。
			subject.login(token);
		} catch (UnknownAccountException e) {
			// {ps} 此用户不存在 ..
			resPath = "redirect:/User/showLogin?errcode=1";
		} catch (IncorrectCredentialsException e) {
			// {ps} 密码错误..
			resPath = "redirect:/User/showLogin?errcode=2";
		} catch (LockedAccountException e) {
			// {ps} 当前用户已锁定 ..
			resPath = "redirect:/User/showLogin?errcode=3";
		}
		return resPath;
	}

	// {ps} 得到一个经过加盐处理, 多次加密的密码
	private String encodeMD5(String oldPass) {
		// {ps} 加密方式
		String hashMethod = "MD5";

		// {ps} 明文密码
		Object credentials = oldPass;

		// {ps} 盐值, 用于和密码混合, 一起加密。
		Object salt = ByteSource.Util.bytes("nchu");

		// {ps} 加密的次数, 可以进行多次的加密操作
		int times = 256;

		Object newPass = new SimpleHash(hashMethod, credentials, salt, times);
		// {ps} 得到一个经过加盐处理, 多次加密的密码
		return newPass.toString();
	}

	private void printMark(Object obj) {
		String mark = "+-----------------------------------------------------------+";
		System.out.println(mark);
		System.out.println(obj);
		System.out.println(mark);
	}

	// Link: user:viewList
	@RequestMapping(value = "/viewList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	// @RequiresPermissions("cource:viewAdd")
	public String viewList() {
		return getHTML("/Cource/viewAdd");
	}
	
	private String getHTML(String title){
		String html = "<style>"+
		"body{ background:#333; color:#DDD; }"+
		"</style>";
		html += "<h1>"+ title +"</h1>";
		return html;
	}

}
