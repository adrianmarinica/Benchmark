package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01174")
public class BenchmarkTest01174 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map30554 = new java.util.HashMap<String,Object>();
		map30554.put("keyA-30554", "a Value"); // put some stuff in the collection
		map30554.put("keyB-30554", param.toString()); // put it in a collection
		map30554.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map30554.get("keyB-30554"); // get it back out
		
		
		Object[] obj = { "a", bar};
		
		response.getWriter().printf(java.util.Locale.US,"notfoo",obj);
	}
}
