package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05126")
public class BenchmarkTest05126 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map17402 = new java.util.HashMap<String,Object>();
		map17402.put("keyA-17402", "a Value"); // put some stuff in the collection
		map17402.put("keyB-17402", param.toString()); // put it in a collection
		map17402.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map17402.get("keyB-17402"); // get it back out
		
		
		response.addHeader("SomeHeader", bar);
	}
}
