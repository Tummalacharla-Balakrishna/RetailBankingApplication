package com.casestudy.retailbank.util;

import javax.servlet.http.HttpSession;

public class SessionChecker {
	
	public static boolean isValidSession(HttpSession session)
	{
		if(session == null || session.isNew())
			return false;
		String userName = (String)session.getAttribute("username");
		if(userName == null)
			return false;
		else
			return true;
	}

}
