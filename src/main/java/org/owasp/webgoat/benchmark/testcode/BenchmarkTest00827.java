package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00827")
public class BenchmarkTest00827 extends HttpServlet {
	
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
		java.util.HashMap<String,Object> map80428 = new java.util.HashMap<String,Object>();
		map80428.put("keyA-80428", "a_Value"); // put some stuff in the collection
		map80428.put("keyB-80428", param.toString()); // put it in a collection
		map80428.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map80428.get("keyB-80428"); // get it back out
		bar = (String)map80428.get("keyA-80428"); // get safe value back out
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}
}
