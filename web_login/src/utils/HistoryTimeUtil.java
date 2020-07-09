package utils;

import javax.servlet.http.Cookie;

public class HistoryTimeUtil {

	public static Cookie getTime(Cookie[] cookies, String string) {
		if (cookies==null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(string)) {
				return cookie;
			}
		}
		return null;
	}
	
}
