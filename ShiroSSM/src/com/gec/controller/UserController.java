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

	// ?errcode=1" ��ַ������
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
		// (1) �õ��û������Ϣ, ƾ֤��Ϣ��
		String username = user.getUsername(); // �����Ϣ
		String password = user.getPassword(); // ƾ֤��Ϣ(û���ܵ�)

		// (2) Ҫ��ƾ֤���� MD5 ���ܴ���
		String md5Pass = encodeMD5(password); // MD5 ���ܵ�

		// (3) ����Щ "���, ƾ֤��Ϣ" ע��һ������: Token��
		UsernamePasswordToken token = new UsernamePasswordToken(username, md5Pass);

		// (4) �õ� ���� Subject��
		Subject subject = SecurityUtils.getSubject();

		// (5) ִ�е�¼, �������ơ�
		// û������, ֱ��ȥ User ��ҳ
		String resPath = "redirect:/User/index";
		try {
			// {ps} ��½ʱ, �Զ����� �Զ��� Realm ����֤������
			subject.login(token);
		} catch (UnknownAccountException e) {
			// {ps} ���û������� ..
			resPath = "redirect:/User/showLogin?errcode=1";
		} catch (IncorrectCredentialsException e) {
			// {ps} �������..
			resPath = "redirect:/User/showLogin?errcode=2";
		} catch (LockedAccountException e) {
			// {ps} ��ǰ�û������� ..
			resPath = "redirect:/User/showLogin?errcode=3";
		}
		return resPath;
	}

	// {ps} �õ�һ���������δ���, ��μ��ܵ�����
	private String encodeMD5(String oldPass) {
		// {ps} ���ܷ�ʽ
		String hashMethod = "MD5";

		// {ps} ��������
		Object credentials = oldPass;

		// {ps} ��ֵ, ���ں�������, һ����ܡ�
		Object salt = ByteSource.Util.bytes("nchu");

		// {ps} ���ܵĴ���, ���Խ��ж�εļ��ܲ���
		int times = 256;

		Object newPass = new SimpleHash(hashMethod, credentials, salt, times);
		// {ps} �õ�һ���������δ���, ��μ��ܵ�����
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
