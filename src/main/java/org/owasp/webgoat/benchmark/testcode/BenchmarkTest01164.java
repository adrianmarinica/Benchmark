package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01164")
public class BenchmarkTest01164 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map25680 = new java.util.HashMap<String,Object>();
		map25680.put("keyA-25680", "a Value"); // put some stuff in the collection
		map25680.put("keyB-25680", param.toString()); // put it in a collection
		map25680.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map25680.get("keyB-25680"); // get it back out
		
		
		response.getWriter().print(bar);
	}
}
