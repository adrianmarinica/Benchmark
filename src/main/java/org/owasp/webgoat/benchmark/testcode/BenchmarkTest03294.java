package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03294")
public class BenchmarkTest03294 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map28845 = new java.util.HashMap<String,Object>();
		map28845.put("keyA-28845", "a Value"); // put some stuff in the collection
		map28845.put("keyB-28845", param.toString()); // put it in a collection
		map28845.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map28845.get("keyB-28845"); // get it back out
		
		
		response.getWriter().write(bar);
	}
}
