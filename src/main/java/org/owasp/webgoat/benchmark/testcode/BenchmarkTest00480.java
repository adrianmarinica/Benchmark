package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00480")
public class BenchmarkTest00480 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map33803 = new java.util.HashMap<String,Object>();
		map33803.put("keyA-33803", "a Value"); // put some stuff in the collection
		map33803.put("keyB-33803", param.toString()); // put it in a collection
		map33803.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map33803.get("keyB-33803"); // get it back out
		
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			Object[] filterArgs = {"a","b"};
			idc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
