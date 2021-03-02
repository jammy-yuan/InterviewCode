package cn.yueqian.utils;

import javax.servlet.http.Cookie;

public class CookieUtil {
	//通过cookie name获得指定cookie
	public static Cookie getCookieByName(String name, Cookie[] cookies) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					return cookie;
				}
			}

		}
		return null;

	}

}
