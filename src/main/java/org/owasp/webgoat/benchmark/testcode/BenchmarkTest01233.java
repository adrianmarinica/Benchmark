package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01233")
public class BenchmarkTest01233 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map73868 = new java.util.HashMap<String,Object>();
		map73868.put("keyA-73868", "a_Value"); // put some stuff in the collection
		map73868.put("keyB-73868", param.toString()); // put it in a collection
		map73868.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map73868.get("keyB-73868"); // get it back out
		bar = (String)map73868.get("keyA-73868"); // get safe value back out
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
